# Aprender QEE

<p> Meu programa é uma calculadora proposta pela materia Orientação a Objetos da UnB - GAMA, essa calculadora foi
feita para uma materia de Engenharia de Energia do mesmo campus a fim de adapatar novas simulações de uma software
que já existe no mercado mas não está completo, esse programa foi feito em JAVA, pela IDE eclipse Oxigen, e funciona
da seguinte forma:

* Primeiramente há uma menu bem basico para que o usuário escolha ente os três tipos de simulações presente nele, sendo
elas: fluxo de potência fundamental, Distorção harmônica e fluxo de potência fundamental.

* Caso o usuario escolha a primeira simulação, ele irá se depara com uma tela com quatro gráficos diferente, sendo eles:
gráfico de corrente, tensão, potência instântanea e triângulo de potência, primeiramente o usuário, digita a amplitude e o 
ângulo correspontedente da tensão e aperta "ok" logo o gráfico irá gerar uma lista e ser plotado na tela, na parte
da corrente é o mesmo passo acima especificado, e quando todos os campos estiverem com todos os valores corretos, 
(caso esteja fora do limite alugum campo, uma mensagem de erro aparece) o gráfico de potência instântane é gerado
e são calculados os valores da potência ativa, reativa,  aparente e fator de potência e através desses valores são
gerados o triângulo de potência.

* Na parte da simulação Distorção harmônica há uma mudada no frame, há em primeira instancia um componente fundamental onde o
usuario vai colocar a amplitude e o angulo da tensão correspondete e gerará um gráfico, por segundo, no painel de harmônicos 
o usuario terá que escolher entre os 6 harmônicos possiveis, todos estão visiveis no frame, mas só poderão ser modificados caso
sejam selecionados, e para cada harmônico selecionado é necessário colocar a amplitude correspondente, o ângulo e a ordem harmônica.
Caso algum campo esteja digitado de forma não coerente, será gerado um erro caso os limites dos mesmos não estejam no padrão,
e quando o segundo botão "ok" é apertado, o gráfico resultante é gerado a partir desses pontos e entradas e logo ao lado mostrado a
série de fourier correspondente aos calculos das entradas.

* Por ultimo há o fluxo de potência harmônico onde é quase a simulação de potência fundamental mas muda que na corrente há o 
campo de ordem harmônica e os calculos finais são de Potência líquida, potência de distorção e fator de potência verdadeiro TPF
refenrênte a simulação especificada.

E para mostrar como as classes estão relaciodas na model (onde há os cálculos), este é o diagrama respondente ao projeto:

<img src="https://gitlab.com/joberth.rogers18/ep2/raw/master/docs/Captura%20de%20tela%20de%202017-11-15%2022-43-20.png" />
