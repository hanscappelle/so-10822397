# Context

A quick and dirty example project for the following StackOverflow question about issues regarding
dynamic views in listadapters in combination with obfuscation.

http://stackoverflow.com/questions/10822397/android-proguard-nullpointer-exception-on-device

# Notes

I had to manually copy the proguard-android.txt config file into the sdk/tools/proguard folder.
Didn't look into this but seems related to this issue: https://code.google.com/p/android/issues/detail?id=72419

By default proguard config is only set up on release in the gradle file (and even there it's disabled).
Set it to true and generate and signed apk to be tested on a device to show the issue.


# Resources

* Using viewholder pattern for performance: http://developer.android.com/training/improving-layouts/smooth-scrolling.html#ViewHolder
* and a more complete example from: http://www.javacodegeeks.com/2013/09/android-viewholder-pattern-example.html
* Listview guide: http://developer.android.com/guide/topics/ui/layout/listview.html
* Another listview guide: http://www.vogella.com/tutorials/AndroidListView/article.html
* Obfuscation relation info: http://developer.android.com/tools/help/proguard.html