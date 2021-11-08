grammar minisys;

WhiteSpace                  : [ \t\n\r] -> skip;
DecimalConst                : NonzeroDigit DecimalConst_;
fragment DecimalConst_      : (Digit DecimalConst_)?;

OctalConst                  : '0' OctalConst_;
fragment OctalConst_        : (OctalDigit OctalConst_)?;

HexadecimalConst            : HexadecimalPrefix HexadecimalDigit HexadecimalConst_;
fragment HexadecimalConst_  : (HexadecimalDigit HexadecimalConst_)?;

Ident           : Nondigit Ident_;
fragment Ident_ : (Nondigit Ident_)? | (Digit Ident_)?;

Nondigit : '_' | 'a' | 'b' | 'c'| 'd'| 'e'| 'f'| 'g'| 'h' | 'i'| 'j'| 'k'| 'l'| 'm' | 'n' | 'o'| 'p'|'q'|'r'|'s'|'t'|'u'|'v'|'w'|'x'|'y'|'z'|
 'A' | 'B' | 'C'|'D'|'E'|'F'|'G'|'H'|'I'|'J'|'K'|'L'|'M'|'N'|'O'|'P'|'Q'|'R'|'S'|'T'|'U'|'V'|'W'|'X'|'Y' | 'Z';
HexadecimalPrefix : '0x' | '0X';
NonzeroDigit      : '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9';
OctalDigit        : '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7';
Digit             : '0' | NonzeroDigit;
HexadecimalDigit  : '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9'
                      | 'a' | 'b' | 'c' | 'd' | 'e' | 'f'
                      | 'A' | 'B' | 'C' | 'D' | 'E' | 'F';
Add               : '+';
Sub               : '-';
Mult              : '*';
Div               : '/';
Mod               : '%';
EqExpSymbol       : '==' | '!=';
RelExpSymbol      : '<'  | '>' | '>=' | '<=';

//grammar rules
compUnit        : funcDef;
funcDef         : funcType main_ident '(' ')' block;
decl            : constDecl | varDecl;

constDecl       : 'const' bType constDef ( ',' constDef )* ';';
constDef        : ident1 '=' constInitVal;
constInitVal    : constExp;
constExp        : addExp;
varDecl         : bType varDef (',' varDef )* ';';
bType           : 'int';
varDef          : ident1 | ident1 '=' initVal;


initVal         : exp ;
funcType        : 'int';
main_ident      : 'main';
block           : '{' (blockItem)* '}';
blockItem       : decl | stmt;
stmt            : lVal '=' exp ';' | (exp)? ';'| block | 'return' exp ';'| 'if' '(' cond ')' stmt ('else' stmt )?;
cond            : lOrExp;
relExp          : addExp
                | relExp (RelExpSymbol) addExp;  // [new]
eqExp           : relExp
                | eqExp (EqExpSymbol) relExp;  // [new]
lAndExp         : eqExp
                | lAndExp '&&' eqExp;  // [new]
lOrExp           : lAndExp
                | lOrExp '||' lAndExp;  // [new]
lVal            : ident1;
exp             : addExp;
addExp          : mulExp | addExp (Add | Sub ) mulExp;
mulExp          : unaryExp | mulExp (Mult | Div | Mod) unaryExp;
unaryExp        : primaryExp | ident1 '(' (funcRParams)? ')'| unaryOp unaryExp;
funcRParams     : exp ( ',' exp )*;
primaryExp      : '(' exp ')' |lVal| number;
unaryOp         : Add | Sub| '!' ;
number          : DecimalConst | OctalConst | HexadecimalConst;
ident1          : Ident;