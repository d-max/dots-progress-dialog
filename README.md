# Spots  progress dialog

[![Maven](https://img.shields.io/badge/jitpack-2.1-brightgreen.svg)](https://bintray.com/d-max/spots-dialog/d-max.spots-dialog/1.1)
&nbsp;&nbsp;
[![Blog Post](https://img.shields.io/badge/medium-post-yellow.svg)](https://medium.com/@dybarsky/spots-progress-dialog-490bd2c737b1)
&nbsp;&nbsp;
[![PlayStore](https://img.shields.io/badge/Play%20Store-demo-blue.svg)](https://play.google.com/store/apps/details?id=dmax.dialog.sample)
&nbsp;&nbsp;
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Spots%20progress%20dialog-lightgrey.svg?style=flat)](http://android-arsenal.com/details/1/1743)

Android AlertDialog with moving spots progress indicator packed as android library.

![Example Image1][1]

===========

### Usage

The library available in maven jcenter repository. You can get it using:
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    implementation 'com.github.serifkazan:spots-dialog:2.0'
}
```
Javadoc and sources package [classifiers][3] available too.

**Note:** The library requires minimum API level 15.

[SpotsDialog][4] class is an inheritor of a AlertDialog class. You can use it just like simple [AlertDialog][5]. For example:
```kotlin
val dialog: AlertDialog = SpotsDialog.Builder().setContext(context).build()
...
dialog.show()
...
dialog.dismiss()
```

### Customization

For dialog customization of dialog, like message and cancel listener, use `SpotsDialog.Builder` methods.

```kotlin
val dialog: AlertDialog = SpotsDialog.Builder()
    .setContext(this)
    .setMessage(R.string.custom_title)
    .setCancelable(false)
    ...
    .build()
    .apply { 
        show() 
    }
...
dialog.dismiss()
```

For changing dialogs look and feel, create style and pass it ot dialog builder:
```kotlin
val dialog: AlertDialog = SpotsDialog.Builder()
    .Builder()
    .setContext(context)
    .setTheme(R.style.Cusom)
    .build()
    .apply {
        show()
    }
```

For styling the next custom attributes provided:
* DialogTitleAppearance : style reference
* DialogTitleText : string
* DialogSpotColor : color
* DialogSpotCount : integer

**For example:**

Provide you own style resource:
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <style name="Custom" parent="android:Theme.DeviceDefault.Dialog">
        <item name="DialogTitleAppearance">@android:style/TextAppearance.Medium</item>
        <item name="DialogTitleText">Updating…</item>
        <item name="DialogSpotColor">@android:color/holo_orange_dark</item>
        <item name="DialogSpotCount">4</item>
    </style>
</resources>
```

Result:

![Example Image1][2]


**Note:**
On the pre-lollipop devices _DialogSpotColor_ item won't work. As workaround just override color in your resources.
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="spots_dialog_color">@color/your_color_value</color>
</resources>
```

### Proguard

If you're using proguard, add this code to your rules file:

```
-keep class dmax.dialog.** {
    *;
}
```

===========


### Release notes

**[v1.1, June 5th 2018][11]**
* Builder provided
* Small fixes

**[v0.7, November 23th 2015][10]**
* Override message setter

**[v0.4, July 23th 2015][9]**
* Add custom message constructor

**[v0.3, May 5th 2015][8]**
* Stop animation when dismiss dialog

**[v0.2, Feb 10th 2015][7]**
* Fix issue on pre-lollipop

**[v0.1, Jan 15th 2015][6]**
* Style customization

===========

### Developed By

Maksym Dybarskyi - http://d-max.info

===========

### License

	The MIT License (MIT)
	Copyright © 2015 Maxim Dybarsky

	Permission is hereby granted, free of charge, to any person obtaining a copy
	of this software and associated documentation files (the “Software”), to deal
	in the Software without restriction, including without limitation the rights
	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	copies of the Software, and to permit persons to whom the Software is
	furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in
	all copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
	THE SOFTWARE.


[1]: http://3.bp.blogspot.com/-l1UvVWiMSAg/VLa5ZfW4dDI/AAAAAAAANTc/rsWou_qb0Bc/s320/Y6HaTSw.gif
[2]: http://1.bp.blogspot.com/-GVktyphQy4U/VLa5jqIF2MI/AAAAAAAANTk/SCtC58KAYHI/s320/plYat1p.gif
[3]: http://www.gradle.org/docs/current/userguide/dependency_management.html#sub:classifiers
[4]: library/src/main/java/dmax/dialog/SpotsDialog.java
[5]: http://developer.android.com/reference/android/app/AlertDialog.html
[6]: https://github.com/d-max/spots-dialog/releases/tag/v0.1
[7]: https://github.com/d-max/spots-dialog/releases/tag/v0.2
[8]: https://github.com/d-max/spots-dialog/releases/tag/v0.3
[9]: https://github.com/d-max/spots-dialog/releases/tag/v0.4
[10]: https://github.com/d-max/spots-dialog/releases/tag/v0.7
[11]: https://github.com/d-max/spots-dialog/releases/tag/v1.1

