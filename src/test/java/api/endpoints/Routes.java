package api.endpoints;

public class Routes {

	/*TC_001	User	Create User	POST	https://petstore.swagger.io/v2/user
TC_002	User	Get User	GET	https://petstore.swagger.io/v2/user/{username}
TC_003	User	Update User	PUT	https://petstore.swagger.io/v2/user/{username}
TC_004	User	Delete User	DELETE	https://petstore.swagger.io/v2/user/{username}
*/
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User module urls
	public static String post_url = base_url + "/user";
	public static String get_url = base_url + "/user/{username}";
	public static String put_url = base_url + "/user/{username}";
	public static String delete_url = base_url + "/user/{username}";
	
	//Pet module urls
	
	
	//Store module urls
	
}
