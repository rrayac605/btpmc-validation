#Introduction 

Proyecto que contiene las reglas de validación para los registros

Orden de compilación

1.- btpmc-commons -> librería(al compilar se incluye en el jar ejecutable)
2.- btpmc-download -> librería(al compilar se incluye en el jar ejecutable)
3.- btpmc-services -> librería(al compilar se incluye en el jar ejecutable)
4.- btpmc-validation -> librería(al compilar se incluye en el jar ejecutable)
5.- btpmc-nssa -> ejecutable
6.- btpmc-sisat -> ejecutable
7.- btpmc-sui55 -> ejecutable

Copiar los archivos que se encuentran en la ruta

/btpmc-validation/src/main/resources/rules-nssa.yml
/btpmc-validation/src/main/resources/rules-sisat.yml
/btpmc-validation/src/main/resources/rules-sui55.yml

A la ruta del servidor

/mspmc-archivos/rules/rules-nssa.yml
/mspmc-archivos/rules/rules-sisat.yml
/mspmc-archivos/rules/rules-sui55.yml

#Getting Started
TODO: Guide users through getting your code up and running on their own system. In this section you can talk about:
1.	Installation process
2.	Software dependencies
3.	Latest releases
4.	API references

#Build and Test
TODO: Describe and show how to build your code and run the tests. 

#Contribute
TODO: Explain how other users and developers can contribute to make your code better. 

If you want to learn more about creating good readme files then refer the following [guidelines](https://www.visualstudio.com/en-us/docs/git/create-a-readme). You can also seek inspiration from the below readme files:
- [ASP.NET Core](https://github.com/aspnet/Home)
- [Visual Studio Code](https://github.com/Microsoft/vscode)
- [Chakra Core](https://github.com/Microsoft/ChakraCore)