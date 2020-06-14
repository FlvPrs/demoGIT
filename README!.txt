Oi, obrigado por ter vindo verificar meu programa.

Aqui vou apenas escrever um pouco do que tem no aplicativo para situar o que esperar.

No aplicativo as tabelas(Aluno, Professor, Curso, Lições) estão populadas com ID de 1 a 10 para serem utilizados nas páginas de busca.

Ao criar um curso você escolhe o período do curso.

Ao Adicionar um professor você escolhe os períodos que o professor está disponível para dar aula.

No gerenciamento do curso você associa quantas lições quiser e na lição pode associar um professor e semestre.

Um curso com período da manhã apenas vai apresentar os professores disponíveis no periodo da manha e uma vez que o professor estiver associado não estará mais disponível pro mesmo período.

No gerenciamento de professores vai aparecer todas lições que o professor está associado, onde você pode retirar aquela aula e disponibilizar o professor novamente para aquele período.

vai ser necessario criar um schema(está sendo utilizado mysql)
configuração de porta padrão 3306
username = demo
password = demo1234

as configurações estão no /demo/src/main/resources/application.properties

Na pasta /demo/src/main/resources/sql está o script do DB.
