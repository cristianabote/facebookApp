# facebookApp

Develop a simplified Facebook app where the end users can use social media services.
You should be able to view NewsFeed, view Friends, view all comments from a specific post, view all likes from a specific post, like a friend's post, comment on friend's post, 
view,create and remove posts.
You should be able to log in/log out.
All entities should be read/store from files. Input parameters can be provided through console.
Write a console application in which the user should log in via username and based on his role (Admin or Social) to be given a menu in which to choose what is the operation 
he wants to run. 

Query the system as to show: 

1. Login:
2. Signup:
3. Edit settings: 

After Login:
1. View NewsFeed
2. View Friends
3. Logout

View NewsFeed
Post Id: 
Username:  
Title:  
Description: 
Comments:  
Likes: 

1. View all Comments from post id: 
2. View all Likes from post id: 
3. Add Comments: 
4. Add Like: 
5. View My Posts: 
6. Delete Post: 
7. Create Post: 
8. Go Back:

My part for this project was to create the Comment Class, the Likes Class and Post Class, and to create the methods mentioned in the requirements: 
getter, setter, readFromFile-WriteInFile(comments,likes,posts), readCommentsByPostId,writeComment,overWriteAllComments,readLikeByPostId,writeLike,
readPostById,addPost,overWriteAllPosts. 
Also, I had a little part to create email exception and password exception in validateUserCredentials, because I wanted to have a strong password when
we create a new user.
