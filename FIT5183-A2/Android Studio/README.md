
- [Android-Health-App](#android-health-app)
  - [Introduction](#introduction)
  - [Functions](#functions)
    - [Login](#login)
    - [Creating a new account](#creating-a-new-account)
    - [Welcome screen](#welcome-screen)
    - [Navigation drawer](#navigation-drawer)
    - [Calorie goal](#calorie-goal)
    - [Daily diet](#daily-diet)
    - [Recording Step](#recording-step)
    - [Tracking calorie](#tracking-calorie)
    - [Calorie Report](#calorie-report)
    - [Map](#map)
- [Requirements](#requirements)


# Android-Health-App

![App icon](http://7xilc8.com1.z0.glb.clouddn.com/health%20android/111.png)

The project aim at recording calories of intake and consumed.

![animation](http://7xilc8.com1.z0.glb.clouddn.com/animation.gif)

If animation is not displaying, Click here [animation](http://7xilc8.com1.z0.glb.clouddn.com/animation.gif)


## Introduction



This project includes 3 activities and some fragments and adapters. 
When you open the application, the MainActivity is showed firstly, which is used to login.
The RegisterActivity is used to sign up.
After you pass login check, you will arrive at the ContentActity which is a navigation drawer and can invoke fragments.
Myutil package includes some method, such as network connection using AsyncTask approach and encrypting password and so on.




## Functions 

### Login

![Login](http://7xilc8.com1.z0.glb.clouddn.com/health%20android/S60428-160617.jpg)

In the screen, you can input name and password to login or sign up a new an account.
After you press sign in button, the application will check your validity from server. If you type wrong name or password, you will get a hint. If your information is correct, you will fly to the welcome screen.

### Creating a new account

![Creating a new account](http://7xilc8.com1.z0.glb.clouddn.com/health%20android/S60428-161352.jpg)

You can fill in the form with your information in this screen.
If there is empty, you will get a hint.
After you finish, you can press the sign up button to submit your information.
If all the information is valid, you get hint to sign in and forward to login screen.

### Welcome screen

![Welcome screen](http://7xilc8.com1.z0.glb.clouddn.com/health%20android/S60428-164102.jpg)

This screen will show your name at the center and time at right corner.
The back end will check whether local database has your information. If not, your information will be added. 
The pen in the screen reminds you should often take records of your intake and consuming situation and you may feel happier when see the kiss.

### Navigation drawer

![Navigation drawer](http://7xilc8.com1.z0.glb.clouddn.com/health%20android/S60428-164105.jpg)

After you login successfully, you can touch it everywhere.
At the header part, you can see your name.
The 6 items as followed can help you get other functions.


### Calorie goal

![Calorie goal](http://7xilc8.com1.z0.glb.clouddn.com/health%20android/S60428-165635.jpg)

You can see your previous goal at this screen, and you can also edit your goal. After editing, you can press button to submit and you will get a confirm dialog for sure.

### Daily diet

![diet 1](http://7xilc8.com1.z0.glb.clouddn.com/health%20android/S60428-173524.jpg)
![diet 2](http://7xilc8.com1.z0.glb.clouddn.com/health%20android/S60428-171210.jpg)

Firstly, you need to select one category which is provided by server database. Secondly, you need to select one food item which is provided by NDB API. After you select one food item you can get more details or add to today’s diet. The category and food items are contained in ListViews.

![diet 3](http://7xilc8.com1.z0.glb.clouddn.com/health%20android/S60428-171449.jpg)

If you press more details button, you will forward to the food details screen. The food information and nutrient details are required from NDB API. The food image is from google custom search. You will see a waiting animation before the image arrives. 

![diet 4](http://7xilc8.com1.z0.glb.clouddn.com/health%20android/S60428-190356.jpg)

If you press add food item button, you can input your quantity of the selected food.
If the item is added successfully, you will get hint and return to welcome screen.

### Recording Step

![Recording Step](http://7xilc8.com1.z0.glb.clouddn.com/health%20android/S60428-192950.jpg)

In the view, you can view all your today’s step records which are put in a ListView. At the bottom, you can input the numbers of steps. These steps records are stored at local database.

### Tracking calorie

![Tracking calorie](http://7xilc8.com1.z0.glb.clouddn.com/health%20android/S60428-192950.jpg)

You can see today’s calorie goal, consumed and burned calories. All these data are received from server.

### Calorie Report

![report 1](http://7xilc8.com1.z0.glb.clouddn.com/health%20android/S60428-193500.jpg)

This function uses the third party – AchartEngine to draw graphs. At the same time, all record of today will insert into server database.
You can see time-step graph with liner, consumed and burned calorie with pie and remaining and goal graph with pie.
At bottom, you can generate a specific day or a duration report.

![report 2](http://7xilc8.com1.z0.glb.clouddn.com/health%20android/S60428-201225.jpg)

If you choose specific day, you will get a calendar view to help you select a specific day. In the screen you can view 2 pie graph based on burned and consumed graph and remaining and goal graph. If there is no record, you will get no record hint.

![report 3](http://7xilc8.com1.z0.glb.clouddn.com/health%20android/S60428-201339.jpg)
If your duration is valid, you can get 3 graphs – the first is consumed and burned calories, the second is step bar graph is steps by time and the third is bar graph which represents the number of days achieving and not achieving goals. 

### Map

![Map](http://7xilc8.com1.z0.glb.clouddn.com/health%20android/S60428-202210.jpg)

At the top, there is text field where you can type somewhere, and after you press show, these relevant places are shown on the map.

# Requirements

- Android Stdio
- Netbeans
- Mysql



