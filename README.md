# My Application
The aim of the project to develop a small application using Karhoo API.

# Setup
The current implementation uses a hard coded auth token for API authentication. Please update the `API_AUTH_TOKEN`
if required

# Architecture
I've tried to follow clean architecture and use MVVM architecture pattern. I use data binding to update the views. 
The application is structures in three layers as explained below. Kotlin is used as primary language. I've used AndroidX libraries 

## Data Layer
Containing the application data layer. The repository utilises a local storage for caching purpose and and also remote service to load the data. 
If the data is not available locally, it will try to load it from the remote service. 

## Domain
Containing the main business logic. The Usecase will use Repository from Data layer to load the data and will apply the
business logic to adapt the raw data to the application data 

## Presentation
Containing the ViewModel and Views. ViewModel will use Usecase from Domain layer to load the required data.

# Languages, libraries and tools used

* Android Support Libraries
* [Room](https://developer.android.com/topic/libraries/architecture/room) 
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
* [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle)
* [Navigation](https://developer.android.com/guide/navigation)
* [Dagger2](https://google.github.io/dagger/)
* [Data Binding](https://developer.android.com/topic/libraries/data-binding)
* [Retrofit](http://square.github.io/retrofit/)
* [Gson](https://github.com/google/gson)
* [Glide](https://github.com/bumptech/glide)
* [Timber](https://github.com/JakeWharton/timber)
