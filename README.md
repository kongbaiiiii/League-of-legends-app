# <p align="center">League of Legends Stat Tracker/Analyzer Application</p>
## Introduction
Welcome to our League of Legends Application, a stat tracker/analyzer and enhancement tool that is designed for players who play the famous worldwide MOBA League of Legends. Our application provides extensive analysis and insights into the gameplay and dives deep into the overall player performances. Our application is designed especially for those who are looking to climb the ranks through a detailed analysis of match and player performance and gives the player a strong understanding of their strengths and weaknesses.However this is not only designed for hardcore competitors looking to climb but also for the casual gamers who just want to learn more about the game and their gameplay. This application is more than just a tool for people to use to tracker their stats, but it also helps you understand the game and reach higher ranks to prevent you from being hardstuck in a certain rank.
## Vision and Mission of our Application
Our goal is to develop a system that allows League of Legend Players regardless of their skill level to monitor their performance and gain useful information to reacher higher ranks and enhance their gameplay over time. We want to transform all the raw data you get from a game of League played and produce meaningful information for the player to take in as well as understanding their strengths and weaknesses allowing them to improve. We mainly want to focus on the player experience as we provide an application that not only tracks statistics but also inspires the player and makes the game more fun through a deeper understanding of the game. Whether you want to climb the ranked leaderboard, find what's holding you back from climbing, learning more about the game or even just to have fun, our application is just for you.
## Comprehensive Features
### Use Cases:
- **Apply Selection**
- **Check Match**
- **Check Player Stat Details**
- **Key Setup**
- **Login**
- **Logout**
- **Return To Main Page**
- **Select Stat**
- **Update**
### Apply Selection:  
This feature updates and tracks your gameplay to show your progress over time. This feature is especially for those who want to improve their gameplay or see their strengths and weaknesses. For this feature you would select exactly 5 of the stats given and when you click apply selection, it will display a graph of your performance based on the selected stats you have chosen. By providing this detailed view, players can track their performance specifically on certain aspects of the game such as farming, staying alive longer, killing, etc.
### Check Match:  
This feature gives you a detailed analysis on your recent matches and gives you a comprehensive understanding of the team composition, your individual performance of the match and overall match outcome(win/lose). This feature provides players with an in depth understand of each match they played and through the match stats, they can analyze how the match resulted in a loss/win and evaluate what they did right and what they can improve on for further matches. This feature is displayed when you click on the more button of each match, and it will show you the match details. This can be significant for finding the meta/strategy of the game such as seeing what champions are played the most throughout your matches and seeing if it results in more wins or losses.
### Check Player Stat Details:  
This feature gives you a comprehensive analysis on your overall individual performance as you can see your overall kda, cs, etc. This feature is designed for those who want to focus on improving specific aspects of their game such as getting a higher kda or cs score. By highlighting the players strengths and weaknesses through the plots, it can really help the player climb up the ranks especially when the stats are visually shown as it is more comprenhesive to most people as opposed to a bunch of numbers and letters. This feature is shown when you select the stats and apply the selection as it will then give you the plots of your selected stats.
### Key Setup:
This feature is used to get into the application as you would need to first get a valid authentication Riot Games API key which then allows you to access your LOL stats. This feature integrates your key with the Riot API and gets all your stats as long as the key you inputted is valid.
### Login:
This feature is used when you successfully enter a generated Riot API key and to login, you would just have to enter a valid playerid which is your league username. However, your playerid is only valid if your league account is #NA1. For this login you would just need to input a valid playerid as no password is required.
### Logout:
This feature is used when you want to exit the application and essentially just sign out of it.
### Return to Main Page:
This feature returns you to the main page and is the default view when a user first logs in to the application.
### Select Stat:
This feature allows you to choose exactly the 5 stats that you want to focus on out of the many stats given to choose from. This is aligned with the use case Check Player Stat Details where in this use case you are selecting the stats that you want to analyze and the other use case shows you the plot of the selected stats. Both these use cases are designed especially for those who want to analyze certain parts of their game and improve or work on specific aspects of the game. This feature can be used for both competitive players and also players that just want to learn and have a fun time during their games.
### Update:
This feature allows the user to update their latest stats and ensures that the application remains current with the users stats such as their matches, overall performance, etc. This feature is on the left part of the main page and everytime you click update, your stats updated to your most recent matches.
## Installation and Setup:
1. Generate a Development Api key from the riot developer portal: https://developer.riotgames.com/
2. Clone this repository: git clone https://github.com/kongbaiiiii/League-of-legends-app.git
3. Make sure to check if the riot api portal is down as it get be down sometimes which will prevent this application from working
4. Go to src and then app and then under app click Main and run main
5. Enter your valid api key that you generated from the riot developer portal and if your key is expired make sure to renew it
6. Once you have entered a valid key, enter a valid playerid which is your league username but make sure it is a #NA1 account or else it won't work due to the Riot API. For example if your League username is wrnmbb#NA1, you should input wrnmbb into the given field.
7. Once you have entered a valid playerid, you have successfully logged in and can now start climbing the ranks or just have a more in depth analysis of your gameplay and overall performance.
## Screenshots/Demos:
## Acknowledgements:
- **Riot Games API**: Utilizing the official Riot API for getting real-time data and statistics
- **Developers and Contributors**: Jack Jiang, Matthew Chen, Daisong Zou, David Fan
## License:
Distributed under the MIT License. See LICENSE.txt for more information.