package com.utsav.stateflowdemo.model


import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("data")
    val data: Data
): BaseResponse() {
    data class Data(
        @SerializedName("account_holder_name")
        val accountHolderName: String,
        @SerializedName("account_number")
        val accountNumber: String,
        @SerializedName("app_notification")
        val appNotification: String,
        @SerializedName("bank_acc_type")
        val bankAccType: String,
        @SerializedName("bank_branch")
        val bankBranch: String,
        @SerializedName("bank_id")
        val bankId: String,
        @SerializedName("bank_name")
        val bankName: String,
        @SerializedName("busy")
        val busy: String,
        @SerializedName("company_id")
        val companyId: String,
        @SerializedName("country")
        val country: String,
        @SerializedName("country_code")
        val countryCode: String,
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("device_token")
        val deviceToken: String,
        @SerializedName("device_type")
        val deviceType: String,
        @SerializedName("driver_docs")
        val driverDocs: DriverDocs,
        @SerializedName("duty")
        val duty: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("email_notification")
        val emailNotification: String,
        @SerializedName("first_name")
        val firstName: String,
        @SerializedName("id")
        val id: String,
        @SerializedName("last_name")
        val lastName: String,
        @SerializedName("lat")
        val lat: String,
        @SerializedName("lng")
        val lng: String,
        @SerializedName("mobile_no")
        val mobileNo: String,
        @SerializedName("profile_image")
        val profileImage: String,
        @SerializedName("rating")
        val rating: String,
        @SerializedName("referral_code")
        val referralCode: String,
        @SerializedName("remember_token")
        val rememberToken: String,
        @SerializedName("status")
        val status: String,
        @SerializedName("trash")
        val trash: String,
        @SerializedName("vehicle_image")
        val vehicleImage: String,
        @SerializedName("vehicle_manufacturer_id")
        val vehicleManufacturerId: String,
        @SerializedName("vehicle_model_id")
        val vehicleModelId: String,
        @SerializedName("vehicle_plate_no")
        val vehiclePlateNo: String,
        @SerializedName("verify")
        val verify: String,
        @SerializedName("x-api-key")
        val xApiKey: String
    ) {
        data class DriverDocs(
            @SerializedName("dlva_exp_date")
            val dlvaExpDate: String,
            @SerializedName("dlva_licence_image")
            val dlvaLicenceImage: String,
            @SerializedName("driver_id")
            val driverId: String,
            @SerializedName("driver_image")
            val driverImage: String,
            @SerializedName("driver_licence_exp_date")
            val driverLicenceExpDate: String,
            @SerializedName("driver_licence_image")
            val driverLicenceImage: String,
            @SerializedName("id")
            val id: String,
            @SerializedName("is_verify_dlva")
            val isVerifyDlva: String,
            @SerializedName("is_verify_driver_licence")
            val isVerifyDriverLicence: String,
            @SerializedName("is_verify_image")
            val isVerifyImage: String,
            @SerializedName("is_verify_mot")
            val isVerifyMot: String,
            @SerializedName("is_verify_pco_badge")
            val isVerifyPcoBadge: String,
            @SerializedName("is_verify_phv")
            val isVerifyPhv: String,
            @SerializedName("is_verify_private")
            val isVerifyPrivate: String,
            @SerializedName("is_verify_road")
            val isVerifyRoad: String,
            @SerializedName("is_verify_v5")
            val isVerifyV5: String,
            @SerializedName("is_verify_vehicle_insurance")
            val isVerifyVehicleInsurance: String,
            @SerializedName("mot_certi")
            val motCerti: String,
            @SerializedName("mot_exp_date")
            val motExpDate: String,
            @SerializedName("pco_badge_exp_date")
            val pcoBadgeExpDate: String,
            @SerializedName("pco_badge_image")
            val pcoBadgeImage: String,
            @SerializedName("phv_exp_date")
            val phvExpDate: String,
            @SerializedName("phv_licence_image")
            val phvLicenceImage: String,
            @SerializedName("private_exp_date")
            val privateExpDate: String,
            @SerializedName("private_insurance_certi")
            val privateInsuranceCerti: String,
            @SerializedName("road_exp_date")
            val roadExpDate: String,
            @SerializedName("road_tax_certi")
            val roadTaxCerti: String,
            @SerializedName("v5_exp_date")
            val v5ExpDate: String,
            @SerializedName("v5_log_book")
            val v5LogBook: String,
            @SerializedName("vehicle_insurance_certi")
            val vehicleInsuranceCerti: String,
            @SerializedName("vehicle_insurance_exp_date")
            val vehicleInsuranceExpDate: String
        )
    }
}