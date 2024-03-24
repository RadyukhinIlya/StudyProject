import com.google.gson.annotations.SerializedName

data class BreweriesDTOItem(
    val address_1: String,
    val address_2: Any,
    val address_3: Any,
    val brewery_type: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    val id: String,
    val latitude: String,
    val longitude: String,
    val name: String,
    val phone: String,
    val postal_code: String,
    @SerializedName("state")
    val state: String,
    val state_province: String,
    val street: String,
    val website_url: String
)