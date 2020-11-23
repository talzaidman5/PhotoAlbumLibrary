# PhotoAlbumLibrary

### FilesSelector
[![](https://jitpack.io/v/talzaidman5/PhotoAlbumLibrary.svg)](https://jitpack.io/#talzaidman5/PhotoAlbumLibrary)
[![API](https://img.shields.io/badge/API-18%2B-green.svg?style=flat)]()
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Photo%20Album%20Library%20-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/7577)
![GitHub repo size](https://img.shields.io/github/repo-size/talzaidman5/PhotoAlbumLibrary)
```
Photo Album Library
Use this libary to use files from you device storage
```
## Setup

Step 1. Add it in your root build.gradle at the end of repositories:
```
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

Step 2. Add the dependency:
```
dependencies {
	       implementation 'com.github.talzaidman5:PhotoAlbumLibrary:Tag'
}
```

## Usage
###### StepProgress Constructor:
```java

// To create photo album from your activity define arrayList in your attributs -
        private ArrayList<String>allPhotos = new ArrayList<>();
	
```
   
## API
// Then add to it all the URLs of the photos you want:
        allPhotos.add("yourURL");


// to init the photo album use the init function
          MainActivityLibrary.initImages(MainActivity.this,allPhotos);

// to add a photo use the addPhoto function
          MainActivityLibrary.addPhoto(MainActivity.this,allPhotos);

// to delete a photo use the deletePhoto function
          MainActivityLibrary.deletePhoto(MainActivity.this,allPhotos);

// to open the photo album use the openAlbum function
          MainActivityLibrary.openAlbum(MainActivity.this,allPhotos);
 ```

## License
```
Copyright (C) 2020, Tal Zaidman
```

