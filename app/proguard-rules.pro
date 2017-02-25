# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\AndroidStudio_2.0\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

#-printmapping proguard.map
#-applymapping mapping.txt

-keepattributes Signature	# 使用gson时一定要记得这个

-ignorewarnings	# 忽略警告

#gson
#-libraryjars /libs/gson-2.2.1.jar
-dontwarn com.google.gson.**
-keep class com.google.gson.** { *;}

#--------- AndFix热修复
-keep class * extends java.lang.annotation.Annotation
-keepclasseswithmembernames class * {
    native <methods>;
}
