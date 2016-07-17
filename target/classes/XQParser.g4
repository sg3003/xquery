parser grammar XQParser;

options {
  tokenVocab=XQLexer;
}


ap : DOC OPENBRACKET FILENAME=STRINGCONST CLOSEBRACKET SINGLESLASH rp #apSlash
   | DOC OPENBRACKET FILENAME=STRINGCONST CLOSEBRACKET DOUBLESLASH rp #apDoubleSlash
   ;

rp : ID  #rpTagname
   | STAR  #rpStar
   | DOT   #rpCurr
   | DOUBLEDOT  #rpParent
   | TXT  #rpTxt
   | AT ID  #rpAttribute
   | OPENBRACKET rp CLOSEBRACKET  #rpBracket
   | left=rp SINGLESLASH right=rp  #rpSlash
   | left=rp DOUBLESLASH right=rp  #rpDoubleSlash
   | rp OPENSQ f CLOSESQ  #rpFilter
   | left=rp COMMA right=rp #rpComma
   ;
   
f : rp  #fRp
  | left=rp EQUAL right=rp #fEqual
  | left=rp EQ right=rp    #fEqual
  | left=rp EQUALITY right=rp #fIs
  | left=rp IS right=rp  #fIs
  | OPENBRACKET f CLOSEBRACKET  #fBracket
  | left=f AND right=f #fAnd
  | left=f OR right=f #fOr
  | NOT f #fNot
  ;

forClause : FOR VARNAME IN xq (COMMA VARNAME IN xq)*
          ;

letClause : LET VARNAME ASSIGN xq(COMMA VARNAME ASSIGN xq)*
          ;
          
whereClause : WHERE cond
            ; 
            
returnClause : RETURN xq
             ;

cond : left=xq EQUAL right=xq #condEqual
     | left=xq EQ right=xq #condEqual
     | left=xq EQUALITY right=xq #condIs
     | left=xq IS right=xq  #condIs
     | EMPTY OPENBRACKET xq CLOSEBRACKET  #condEBracket
     | SOME VARNAME IN xq (COMMA VARNAME IN xq)* SATISFIES cond  #condSome
     | OPENBRACKET cond CLOSEBRACKET #condBracket
     | left=cond AND right=cond #condAnd
     | left=cond OR right=cond #condOr
     | NOT cond #condNot
     ;


xqs: oxq | xq;

oxq : FOR forJ WHERE condJ RETURN returnJ #rewriteXq 
    ;
 
xq : VARNAME  #xqVar
   | STRINGCONST #xqStr
   | ap  #xqAp
   | OPENBRACKET xq CLOSEBRACKET #xqBracket
   | left=xq COMMA right=xq #xqComma
   | xq SINGLESLASH rp #xqSlash
   | xq DOUBLESLASH rp #xqDoubleSlash
   | OPENTAG ID CLOSETAG OPENCURL xq CLOSECURL OPENTAG ID CLOSETAG #xqTags
   | forClause (letClause)? (whereClause)? returnClause #xqComplex
   | letClause xq #xqLet
   | JOIN OPENBRACKET left=xq COMMA right=xq COMMA leftlist=list COMMA rightlist=list CLOSEBRACKET #xqJoin
   ;
 

list : OPENSQ (ID (COMMA ID)*)* CLOSESQ ;
 
  
forJ : VARNAME IN path (COMMA VARNAME IN path)*  #jfor ;

path : ap #pathAp
     | VARNAME SINGLESLASH rp #pathSlash
     | VARNAME DOUBLESLASH rp #pathDSlash
     ;

condJ : left=VARNAME EQ right=VARNAME #jEq
      | left=VARNAME EQUAL right=VARNAME #jEq
      | lt=condJ AND rt=condJ #jAnd
      | VARNAME EQ STRINGCONST #jEqS
      | VARNAME EQUAL STRINGCONST #jEqS
      ;

returnJ : path
        | VARNAME
        | OPENBRACKET returnJ CLOSEBRACKET COMMA OPENBRACKET returnJ CLOSEBRACKET
        | returnJ COMMA returnJ
        | OPENTAG lt=ID CLOSETAG OPENCURL returnJ CLOSECURL OPENTAG rt=ID CLOSETAG
        ;
     
