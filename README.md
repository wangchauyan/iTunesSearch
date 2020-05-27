# iTunes Search App
A demo for showing how to use iTunes Search API to search artworks. 

## Architeture
This demo adpates some design patterns. In the UI layer, it uses [MVP](https://personaldevblog.firebaseapp.com/2020/03/20/MVC-MVP-and-MVVM-design-patterns-on-Android) to shape the connections between `Views` and business logics which categories into two different important components, `Presenters` and `Models`. 

It also uses the Clean architecture to construct the whole App. The CLEAN architecture comes from [here](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html). There are two features of this CLEAN architecture if you look at the circle diagram. The circles represent different levels of software in your app. There are two key things to note: 

- The center circle is the most abstract, and the outer circle is the most concrete. This is called the `Abstraction Principle`. The `Abstraction Principle` specifies that inner circles should contain business logic, and outer circles should contain implementation details.

- Another principle of Clean Architecture is the `Dependency Rule`. This rule specifies that each circle can depend only on the nearest inward circle — this is what makes the architecture work.

These two key things bring a very clear picture for developers: the outer circle represents the concrete mechanisms that are specific to the platform. Moving inward, each circle is more abstract and higher-level. The center circle is the most abstract and contains business logic, which doesn’t rely on the platform or the framework you’re using. This Clean Architecture maximizes the use of `SOLID` principle. That's also the main reason I chose to use Clean architecture as a main design pattern for the whole project. 

Let's step back a little bit and see how this App uses `CLEAN` to construct the layers. To be honest, it doens't define how many layers you should have in your project. I will do four layers for this project based on my experience in the past projects. 

- `Presentation`: A layer that interacts with the UIs.
- `Domain` included `Use Cases`: Contains the business logic and actions that users can trigger.
- `Data`: A abstract definition of all the data sources. 
- `Framework`(a.k.a `Remote` here in this project): Provides the concrete implementation for the `Data` layer. Here we provide the `Remote` data source for data feeding. 

Let's see the design diagram to gain more clear understanding. 
![iTunes Search App Structure]
(https://github.com/wangchauyan/iTunesSearch/images/iTunes_Search_App_Structure.png)


# Reference 
1. [iTunes Search API](https://developer.apple.com/library/archive/documentation/AudioVideo/Conceptual/iTuneSearchAPI/Searching.html#//apple_ref/doc/uid/TP40017632-CH5-SW1)
