GET("http://localhost:8080/greeting") {
    header("Accept", "application/json")
    queryParam("param", "value")
}
GET("http://localhost:8080/greeting?name=User") {
    header("Accept", "application/json")
    queryParam("param", "value")
}
POST("http://localhost:8080/put_user") {
    header("Content-Type", "application/json")
    body(
        """
        {
        "id": 1,
        "name": "Ivan"
        }
        """.trimIndent()
    )
}