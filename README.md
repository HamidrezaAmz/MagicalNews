# MagicalNews
This repo is based on MVVM + Clean Architecture that contains some sort of android framework common technologies!


## Technologies 
- Flow and Coroutine
- Room as Database
- Hilt as dependecy injector
- Retrofit as Api caller
- Google GSON as json parser and convertor
- Lifecycle for ViewModel and LiveData

## Layers of Clean Architecture
In this repo I try to use clean principles. Let's take a look at Clean Architecture diagram.


![1_02Ink_nKAVnzLS8NA3rm_A](https://user-images.githubusercontent.com/13493645/172063188-c8e0ae42-23f1-4849-ad8f-472346a03dfa.png)

Clean architecture is a method of software development in which you should be able to identify what a program performs merely by looking at its source code. The programming language, hardware, and software libraries needed to achieve the program’s goal should be rendered obsolete.

As you see we have 3 main layers: **Presentation** , **Domain**, **Data**

- **Presentation or APP**: A layer that interacts with the UI, mainly Android Stuff like Activities, Fragments, ViewModel, etc. It would include both domain and data layers.
- **Domain**: Contains the business logic of the application. It is the individual and innermost module. It’s a complete java module.
- **Data**: It includes the domain layer. It would implement the interface exposed by domain layer and dispenses data to app


## Network API

In this project I use [News API](https://newsapi.org/) as backend provider. It is a simple, easy-to-use REST API that returns JSON search results for current and historic news articles published by over 80,000 worldwide sources. 


# Conclusion
As developer you can have your own layers and directories, the above project is just a sample of my View on Clean architecture.
