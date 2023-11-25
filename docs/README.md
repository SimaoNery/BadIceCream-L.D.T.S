# LDTS 1008 - Bad Ice Cream

Neste jogo de _arcade_ poderás ajudar o Bad Ice Cream a roubar as suas frutas favoritas. Mas cuidado, a fruta tem dono e os monstros que a protegem não gostam nada de ladrões. Utiliza o poder de criar e destruir paredes de gelo do Bad Ice Cream, para encurralar os monstros e encher a barriga à vontade.

# _Features_ Implementadas
- Movimento do Bad Ice Cream: O personagem irá mover-se para cima (seta para cima), para baixo (seta para baixo), para esquerda (seta para a esquerda) ou para a direita (seta para a direita), de acordo com o input do utilizador;

![](resources/IceCreamMovement.gif)

- Movimento do DefaultMonster: O DefaultMonster irá mover-se aleatoriamente pelos espaços livres no mapa, é o monstro mais lento, aproveita!;

![](resources/DefaultMonster.gif)

- Colisão Bad Ice Cream: O personagem morre quando colide com monstros e é proibido de avançar no caso de colidir com uma parede;

<img src="resources/Collision.gif" width="250" height="250" />

- Colisão Monstros: Os monstros nao podem avançar no caso de coliderem com outro monstro ou com uma parede;

**SCREENSHOTS MISSING**


# _Features_ Planeadas
## _In-Game Features_ 
- Habilidade do Personagem: Quando a tecla de espaço for pressionada, o personagem irá construir uma parede de gelo até ao primeiro bloqueio que lhe aparecer (monstro, fruta, parede ou hot floor). No caso de já existir uma parede de gelo à sua frente, o personagem irá destruí-la em cascada (para até encontrar espaço vazio ou Stone Wall);

![](resources/IceCreamAbility.gif)

- Movimento do RunnerMonster: O RunnerMonster inicialmente irá ter o comportamento de um Defaultmonster, mas em intervalos de curto período de tempo, a sua velocidade será aumentada e este passará a conseguir localizar o personagem (cálculo da trajetória mais curta), por isso foge enquanto podes;

![](resources/Runner.gif)

- Movimento do JumperMonster: O JumperMonster será capaz de saltar para cima de paredes de modo a conseguir percorrer sempre o caminho mais curto até à personagem principal;

![](resources/Jumper.gif)

- Movimento do WallBreakerMonster: O WallBreakerMonster terá a habilidade de destruir paredes de gelo do mesmo modo que a personagem principal;

![](resources/WallBreaker.gif)

- PowerUp do Morango: O Morango é uma fruta rara que dará ao personagem um escudo (o IceCream fica azul), que o deixará imune ao toque de um monstro;

![](resources/StrawberryAbility.gif)

- _Hot Floor_: No mapa irão existir zonas onde o IceCream não conseguirá criar paredes de gelo, apesar de ser possível caminhar por cima destas normalmente;

![](resources/HotTile.gif)

- Colisão Personagem - Fruta: Quando o personagem avança para uma zona onde já existe uma fruta, coleta a fruta e dependendo do tipo de fruta, terá diferentes PowerUp's;

![](resources/EatFruit.gif)

- Sons no Jogo: Durante todo o jogo haverá música a passar em plano de fundo, sendo estas diferentes entre os menus, durante o jogo (quando destrói paredes, quanto colhe fruta, etc) e quando o jogador perde. 

## Menus
- Menu Principal: Quando o jogo é iniciado, o "Main Menu" é aberto. Neste, o jogador poderá escolher entre começar a jogar, aceder às instruções ou sair do jogo;
<img src="resources/MainMenu.png" width="250" height="250" />
- Instruções: Ao escolher a opção "Instructions" no "Main Menu", o jogador tem acesso a uma página com uma descrição do jogo e os controlos para jogar;
<img src="resources/Instructions.png" width="250" height="250" />
- Seleção de Nível: Ao escolher a opção "Start Game" no "Main Menu", outro menu é aberto, onde será possível escolher entre os diferentes níveis existentes. Com exceção ao nível 1, só é possível escolher um nível se o anterior tiver sido completado com sucesso;
<img src="resources/LevelSelect.png" width="250" height="250" />
- Menu de Pausa: No decorrer do jogo, o jogador pode clicar na tecla _Escape_, abrindo um menu que pausa o jogo. Neste, poderá escolher entre continuar a jogar ou sair para o "Main Menu".
<img src="resources/PauseMenu.png" width="250" height="250" />
- Menu de Fim de Nível: Após um nível ser terminado, um novo menu irá abrir, onde o utilizador poderá escolher entre continuar para o próximo nível, ou retornar ao menu principal;
<img src="resources/LevelCompleteMenu.png" width="250" height="250" />
- Menu de Fim de Jogo: Ao ser morto por um dos monstros, será aberto um menu onde o utilizador poderá escolher entre jogar novamente, ou voltar ao menu principal.
<img src="resources/GameOver.png" width="250" height="250" />


# Design 
## Padrão Arquitetural
### Contexto do Problema

Desde o início do projeto, visou-se desenvolver uma estrutura que fosse bem organizada, de modo ao código ser fácil de ler e de se tornar trivial a localização de snippets de código nos diversos ficheiros, permitindo ainda, que diversas pessoas consigam alterar o código, sem prejudicarem o trabalho dos outros.

### Padrão
Com estes problemas em mente, optou-se por aplicar o padrão arquitetural MVC (Model View Controller), que divide o programa em três camadas, View, Model e Controller. A camada Model contém apenas os dados, já a View é responsável pela interface com a qual o jogado vai interagir, tendo em conta os dados atuais e envia ações do utilizador para o Controller. Esta última camada envia os dados do Model para o View e interpreta os inputs recebidos pelo utilizador e fornecidos pelo View. 

### Implementação
A implantação deste padrão pode ser representada através do seguinte modelo U.M.L:

<img src="resources/MVC.drawio%20(1).png" width="1100" height="550" />


As 3 classes podem ser encontradas nos seguintes links:
- Controller-(https://github.com/FEUP-LDTS-2023/project-l10gr08/tree/main/src/main/java/org/example/controller)
- Model-(https://github.com/FEUP-LDTS-2023/project-l10gr08/tree/main/src/main/java/org/example/model)
- View-(https://github.com/FEUP-LDTS-2023/project-l10gr08/tree/main/src/main/java/org/example/viewer)

### Consequências
A escolha deste padrão trouxe vantagens e desvantagens:

Vantagens
- Melhorar a manutenção do código, uma vez que é fácil de localizar os erros e em caso de adições apenas é necessário criar um novo elemento viewer, controller ou model;
- Simplicidade na criação de testes;
- Código fácil de ler;
- Divisão em partes "independentes", permite a várias pessoas desenvolver o código em simultâneo, sem conflitos.

Desvantagens
- É necessário um melhor planeamento prévio e mais atenção na escrita do código, uma vez que as componentes estão separadas.

## Padrão de Estado
### Contexto do Problema
Ao longo do jogo, é possível que um objeto se encontre em diferentes estados, o que pode afetar o comportamento de todo o programa. Haveria então uma grande dependência em if ’s e switch cases’s, o que tornaria a interpretação do código mais complexa, uma vez que todos os comportamentos seriam executados por apenas uma classe, bem como dificultaria a extensão do código.

### Padrão
O State Pattern permite resolver este problema facilmente, pegando no código que posteriormente estaria numa só classe e dividindo-o em várias classes, fazendo com que o objeto consiga mudar de comportamento quando o seu estado muda. Esta abordagem faz sentido quando um objeto atua de forma diferente consoante o seu estado interno. (Como por exemplo nos estados dos diversos Menus utilizados)
### Implementação
**UML TO BE DONE**

O código para as classes que estendem State ainda não está completo, mas a sua base encontra-se nos seguintes links:
• GameState-(https://github.com/FEUP-LDTS-2023/project-l10gr08/blob/main/src/main/java/org/example/states/GameState.java)
• MainMenuState-(https://github.com/FEUP-LDTS-2023/project-l10gr08/blob/main/src/main/java/org/example/states/MainMenuState.java)
• PauseMenuState-(https://github.com/FEUP-LDTS-2023/project-l10gr08/blob/main/src/main/java/org/example/states/PauseMenuState.java)

### Consequências
A escolha deste padrão trouxe várias vantagens:

Vantagens
- Remove a dependência em if’s e switch case’s;
- Torna o código mais fácil de ler;
- Torna a correção do código e a criação de testes mais simples;
- Ao introduzir novos estados deixa de ser necessário mudar estados já existentes.

   
## _Code Smells_
**TO BE DONE**

## Testes
### _Coverage Report_

**TO BE DONE**

### _Mutation Testing Report_

**TO BE DONE**

## Self-evaluation
**To BE DONE**
