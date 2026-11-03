GET("http://localhost:8080/greeting") {
    header("Accept", "application/json")
    queryParam("param", "value")
}
GET("http://localhost:8080/greeting?name=User") {
    header("Accept", "application/json")
    queryParam("param", "value")
}
GET("http://localhost:8080/get_user/1") {
    header("Accept", "application/json")
    queryParam("param", "value")
}
GET("http://localhost:8080/get_user/2") {
    header("Accept", "application/json")
    queryParam("param", "value")
}
GET("http://localhost:8080/get_all_users") {
    header("Accept", "application/json")
    queryParam("param", "value")
}
POST("http://localhost:8080/put_user") {
    header("Content-Type", "application/json")
    body(
        """
        {
        "id": 1,
        "name": "Ivan",
        "age": 20
        }
        """.trimIndent()
    )
}
POST("http://localhost:8080/put_user") {
    header("Content-Type", "application/json")
    body(
        """
        {
        "id": -1,
        "name": "Ivan",
        "age": -20
        }
        """.trimIndent()
    )
}