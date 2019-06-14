# LoggingModule

This is a lightweight Android log component. 

[Document](https://github.com/chubecode)   

## Features  
- [x] Support Json,Array ,List , Object
- [x] Support ToastLogger
- [x] Supports custom Logger  
- [x] Support saved Log
## Screenshots
![screenshots](https://github.com/chubecode/TestLogModule/blob/master/screenshoot/screenshoot.PNG "screenshots")

## Download
Gradle:
```
not yet
```

## Usage
# Init

``` kotlin
//setup logger client
val toastLogger = ToastLogger("apiKey")
val instaLogger = InstaLogger("apiKey")
val customLogger = CustomLogger("apiKey")

//set logger client
LogX.init(
     toastLogger,
     instaLogger,
     customLogger,
     ...
)

```

# Log Message

``` kotlin
LogX.v("Tag", "Message", "Content1", "Content2")
LogX.d("Tag", "Message", "Content1", "Content2")
LogX.e("Tag", "Message", "Content1", "Content2")
...
```

# Log Array, Json, Object

``` kotlin
//Array
val pets = arrayOf(
                Pet("Husky", 5),
                Pet("Golden", 6),
                Pet("Puppy", 7),
                Pet("Pug", 8)
            )
LogX.v("Main", "Array", pets)

//Json
val json = "{'a':'b','c':{'aa':234,'dd':{'az':12}}}"
LogX.e("Main", "Json", json)

//Object
val pet = Pet("Husky", 5)
LogX.i("Main", "Object", pet)         

```

# Send Debug log (saved logs)

``` kotlin
LogX.sendDebugLog(Throwable(KotlinNullPointerException()))

```

#Thanks
