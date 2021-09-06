from matrices import *


def pick_number(text: str):
    return int(text.strip())


def is_num_char(ch: str):
    if ch not in ['1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '.','+']:
        return False
    else:
        return True





def main(text):
    ls=text.split('\n')
    print(ls)
    n=int(ls[0].strip())
    txt=ls[1].strip()
    variables=txt.split(',')
    count = 0
    A = []  # matrix to store the coefficients of variables
    B = []  # matrix to store the constants present at right side of the equation
    for i in range(2,len(ls)):
        eq=ls[i].strip()

        ind = eq.find('=')
        c = list((pick_number(eq[ind + 1:]),))
        var_list = []
        num = ''
        for i in eq[:ind]:
            if is_num_char(i):
                num += i
            else:
                if num=='+':
                    var_list.append(float(1))
                elif num=='-':
                    var_list.append(float(-1))
                else:
                    var_list.append(float(num))
                num = ''
        A.append(var_list)
        B.append(c)
    A=matrix(A)
    B=matrix(B)
    inv_A=A.inverse()
    X=inv_A*B

    output=''
    for i in range(0,len(X.matrix)):
        output+=str(variables[i])+'='+str(round(X.matrix[i][0],7))
        output+='\n'
    return output

    
