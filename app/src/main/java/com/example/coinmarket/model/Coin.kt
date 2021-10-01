package com.example.coinmarket.model

data class Coin(
    var status: Status?,
    var data: List<Data>?
)

data class Status(
    var timestamp: String?,
    var error_code: Long?,
    var error_message: Any?,
    var elapsed: Long?,
    var credit_count: Long?,
    var notice: Any?,
    var total_count: Long?
)

data class Data(
    var id: Long?,
    var name: String?,
    var symbol: String?,
    var slug: String?,
    var num_market_pairs: Double?,
    var date_added: String?,
    var max_supply: Double?,
    var circulating_supply: Double?,
    var total_supply: Double?,
    var platform: Any?,
    var cmc_rank: Double?,
    var last_updated: String?,
    var quote: Quote?
)

data class Quote(
    var USD: USD?
)

data class USD(
    var price: Double?,
    var volume_24h: Double?,
    var percent_change_1h: Double?,
    var percent_change_24h: Double?,
    var percent_change_7d: Double?,
    var percent_change_30d: Double?,
    var percent_change_60d: Double?,
    var percent_change_90d: Double?,
    var market_cap: Double?,
    var market_cap_dominance: Double?,
    var fully_diluted_market_cap: Double?,
    var last_updated: String?
)
