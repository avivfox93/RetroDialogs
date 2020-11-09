# RetroDialogs
[![](https://jitpack.io/v/avivfox93/RetroDialogs.svg)](https://jitpack.io/#avivfox93/RetroDialogs)

## How to Use:
Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
Then add the dependency
```gradle
dependencies {
        implementation 'com.github.avivfox93:RetroDialogs:Tag'
}
```

## Example:
Creating a Windows retro like Info Dialog:
```java
windowsDialog.enableYesButton(()->{
    Log.e("Retro","Yes selected");
});
windowsDialog.enableNoButton(()->{
    Log.e("Retro","No selected");
});
windowsDialog.enableCancelButton(()->{
    Log.e("Retro","Cancel selected");
    windowsDialog.dismiss();
});
windowsDialog.enableExitButton(()->{
    Log.e("Retro","Exit selected");
    windowsDialog.dismiss();
});

windowsDialog.setDialogType(RetroDialog.DialogType.INFO);
windowsDialog.show();
```