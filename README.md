# votingApp
`votingApp` is a desktop application for automatic and real-time election management.

>Watch the demonstration on youTube: [VotingApp](https://youtu.be/gs1yInbSJEA)

# libs

For the functioning of the application, it requires that some libraries are integrated in the project. So, you have to integrate the libraries that are in the `/libs` folder in your project.
Note that this project is designed with `JDK 1.8`.

# configuration & database
The project needs to be connected to a database to work, so we used MYSQL.
You must first import the `.sql` file in the `/bd` folder into your database server.

Then you will modify `YOUR PASSWORD` in the file `GetConnection.java` at the root `src/cm/ens/bd` by your own password to connect to the server. Leave a blank field if you don't have a password.

```java
public class GetConnection {

    public static Connection getConnnection() throws SQLException, ClassNotFoundException {

        Connection myConne = null;
        Class.forName("com.mysql.jdbc.Driver");
        myConne = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ens", "root", "YOUR PASSWORD");
        System.out.println("Connecté !");
  
        return myConne;
    }
}
 ```

# login
Once you have launched the application you must log in as either administrator or voter.

![](/imgs/login.png)

# administrator

Some administrator side features

`Add candidate`

![](/imgs/addcandidat.png)

`View the voting results`

![](/imgs/result.png)

# elector

Some elector side features

`Vote for a candidate`

![](/imgs/elector.png)


