# Pickle - The fastest image picker for Android
## 🚧🚧Work in Progress🚧🚧
[ ![Download](https://api.bintray.com/packages/charlezz/Pickle/com.charlezz.pickle/images/download.svg?version=1.0.0-alpha) ](https://bintray.com/charlezz/Pickle/com.charlezz.pickle/1.0.0-alpha/link)
<p>
<img src="https://github.com/Charlezz/Pickle/blob/main/pickle.jpg" width="200">
<br>
Designed based on Paging3.

## Installation
```bash
implementation 'com.charlezz:pickle:1.0.0-alpha'
```
## How to use
1. Initilization
The launcher MUST be initialized before Lifecycle.State.STARTED
```bash
val launcher:ActivityResultLauncher<Config> = getPickle { mediaList:List<Media> ->
    //handle the result
}
```
2. Configure your Config if you want and call launch() function
```bash
launcher.launch(Config.default)
```
