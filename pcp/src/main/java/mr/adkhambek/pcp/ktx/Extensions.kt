package mr.adkhambek.pcp.ktx

import android.annotation.SuppressLint
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import mr.adkhambek.pcp.R
import mr.adkhambek.pcp.model.Country


@ExperimentalCoroutinesApi
fun EditText.editFlow() = callbackFlow<String> {
    val textWatcher = doAfterTextChanged {
        offer(it.toString())
    }
    awaitClose { removeTextChangedListener(textWatcher) }
}

@SuppressLint("DefaultLocale")
fun getFlagMasterResID(country: Country): Int {
    return when (country.nameCode.toLowerCase()) {
        "ad" -> R.drawable.flag_andorra
        "ae" -> R.drawable.flag_uae
        "af" -> R.drawable.flag_afghanistan
        "ag" -> R.drawable.flag_antigua_and_barbuda
        "ai" -> R.drawable.flag_anguilla
        "al" -> R.drawable.flag_albania
        "am" -> R.drawable.flag_armenia
        "ao" -> R.drawable.flag_angola
        "aq" -> R.drawable.flag_antarctica
        "ar" -> R.drawable.flag_argentina
        "as" -> R.drawable.flag_american_samoa
        "at" -> R.drawable.flag_austria
        "au" -> R.drawable.flag_australia
        "aw" -> R.drawable.flag_aruba
        "ax" -> R.drawable.flag_aland
        "az" -> R.drawable.flag_azerbaijan
        "ba" -> R.drawable.flag_bosnia
        "bb" -> R.drawable.flag_barbados
        "bd" -> R.drawable.flag_bangladesh
        "be" -> R.drawable.flag_belgium
        "bf" -> R.drawable.flag_burkina_faso
        "bg" -> R.drawable.flag_bulgaria
        "bh" -> R.drawable.flag_bahrain
        "bi" -> R.drawable.flag_burundi
        "bj" -> R.drawable.flag_benin
        "bl" -> R.drawable.flag_saint_barthelemy // custom
        "bm" -> R.drawable.flag_bermuda
        "bn" -> R.drawable.flag_brunei
        "bo" -> R.drawable.flag_bolivia
        "br" -> R.drawable.flag_brazil
        "bs" -> R.drawable.flag_bahamas
        "bt" -> R.drawable.flag_bhutan
        "bw" -> R.drawable.flag_botswana
        "by" -> R.drawable.flag_belarus
        "bz" -> R.drawable.flag_belize
        "ca" -> R.drawable.flag_canada
        "cc" -> R.drawable.flag_cocos // custom
        "cd" -> R.drawable.flag_democratic_republic_of_the_congo
        "cf" -> R.drawable.flag_central_african_republic
        "cg" -> R.drawable.flag_republic_of_the_congo
        "ch" -> R.drawable.flag_switzerland
        "ci" -> R.drawable.flag_cote_divoire
        "ck" -> R.drawable.flag_cook_islands
        "cl" -> R.drawable.flag_chile
        "cm" -> R.drawable.flag_cameroon
        "cn" -> R.drawable.flag_china
        "co" -> R.drawable.flag_colombia
        "cr" -> R.drawable.flag_costa_rica
        "cu" -> R.drawable.flag_cuba
        "cv" -> R.drawable.flag_cape_verde
        "cw" -> R.drawable.flag_curacao
        "cx" -> R.drawable.flag_christmas_island
        "cy" -> R.drawable.flag_cyprus
        "cz" -> R.drawable.flag_czech_republic
        "de" -> R.drawable.flag_germany
        "dj" -> R.drawable.flag_djibouti
        "dk" -> R.drawable.flag_denmark
        "dm" -> R.drawable.flag_dominica
        "do" -> R.drawable.flag_dominican_republic
        "dz" -> R.drawable.flag_algeria
        "ec" -> R.drawable.flag_ecuador
        "ee" -> R.drawable.flag_estonia
        "eg" -> R.drawable.flag_egypt
        "er" -> R.drawable.flag_eritrea
        "es" -> R.drawable.flag_spain
        "et" -> R.drawable.flag_ethiopia
        "fi" -> R.drawable.flag_finland
        "fj" -> R.drawable.flag_fiji
        "fk" -> R.drawable.flag_falkland_islands
        "fm" -> R.drawable.flag_micronesia
        "fo" -> R.drawable.flag_faroe_islands
        "fr" -> R.drawable.flag_france
        "ga" -> R.drawable.flag_gabon
        "gb" -> R.drawable.flag_united_kingdom
        "gd" -> R.drawable.flag_grenada
        "ge" -> R.drawable.flag_georgia
        "gf" -> R.drawable.flag_guyane
        "gg" -> R.drawable.flag_guernsey
        "gh" -> R.drawable.flag_ghana
        "gi" -> R.drawable.flag_gibraltar
        "gl" -> R.drawable.flag_greenland
        "gm" -> R.drawable.flag_gambia
        "gn" -> R.drawable.flag_guinea
        "gp" -> R.drawable.flag_guadeloupe
        "gq" -> R.drawable.flag_equatorial_guinea
        "gr" -> R.drawable.flag_greece
        "gt" -> R.drawable.flag_guatemala
        "gu" -> R.drawable.flag_guam
        "gw" -> R.drawable.flag_guinea_bissau
        "gy" -> R.drawable.flag_guyana
        "hk" -> R.drawable.flag_hong_kong
        "hn" -> R.drawable.flag_honduras
        "hr" -> R.drawable.flag_croatia
        "ht" -> R.drawable.flag_haiti
        "hu" -> R.drawable.flag_hungary
        "id" -> R.drawable.flag_indonesia
        "ie" -> R.drawable.flag_ireland
        "il" -> R.drawable.flag_israel
        "im" -> R.drawable.flag_isleof_man // custom
        "is" -> R.drawable.flag_iceland
        "in" -> R.drawable.flag_india
        "io" -> R.drawable.flag_british_indian_ocean_territory
        "iq" -> R.drawable.flag_iraq_new
        "ir" -> R.drawable.flag_iran
        "it" -> R.drawable.flag_italy
        "je" -> R.drawable.flag_jersey
        "jm" -> R.drawable.flag_jamaica
        "jo" -> R.drawable.flag_jordan
        "jp" -> R.drawable.flag_japan
        "ke" -> R.drawable.flag_kenya
        "kg" -> R.drawable.flag_kyrgyzstan
        "kh" -> R.drawable.flag_cambodia
        "ki" -> R.drawable.flag_kiribati
        "km" -> R.drawable.flag_comoros
        "kn" -> R.drawable.flag_saint_kitts_and_nevis
        "kp" -> R.drawable.flag_north_korea
        "kr" -> R.drawable.flag_south_korea
        "kw" -> R.drawable.flag_kuwait
        "ky" -> R.drawable.flag_cayman_islands
        "kz" -> R.drawable.flag_kazakhstan
        "la" -> R.drawable.flag_laos
        "lb" -> R.drawable.flag_lebanon
        "lc" -> R.drawable.flag_saint_lucia
        "li" -> R.drawable.flag_liechtenstein
        "lk" -> R.drawable.flag_sri_lanka
        "lr" -> R.drawable.flag_liberia
        "ls" -> R.drawable.flag_lesotho
        "lt" -> R.drawable.flag_lithuania
        "lu" -> R.drawable.flag_luxembourg
        "lv" -> R.drawable.flag_latvia
        "ly" -> R.drawable.flag_libya
        "ma" -> R.drawable.flag_morocco
        "mc" -> R.drawable.flag_monaco
        "md" -> R.drawable.flag_moldova
        "me" -> R.drawable.flag_of_montenegro // custom
        "mf" -> R.drawable.flag_saint_martin
        "mg" -> R.drawable.flag_madagascar
        "mh" -> R.drawable.flag_marshall_islands
        "mk" -> R.drawable.flag_macedonia
        "ml" -> R.drawable.flag_mali
        "mm" -> R.drawable.flag_myanmar
        "mn" -> R.drawable.flag_mongolia
        "mo" -> R.drawable.flag_macao
        "mp" -> R.drawable.flag_northern_mariana_islands
        "mq" -> R.drawable.flag_martinique
        "mr" -> R.drawable.flag_mauritania
        "ms" -> R.drawable.flag_montserrat
        "mt" -> R.drawable.flag_malta
        "mu" -> R.drawable.flag_mauritius
        "mv" -> R.drawable.flag_maldives
        "mw" -> R.drawable.flag_malawi
        "mx" -> R.drawable.flag_mexico
        "my" -> R.drawable.flag_malaysia
        "mz" -> R.drawable.flag_mozambique
        "na" -> R.drawable.flag_namibia
        "nc" -> R.drawable.flag_new_caledonia // custom
        "ne" -> R.drawable.flag_niger
        "nf" -> R.drawable.flag_norfolk_island
        "ng" -> R.drawable.flag_nigeria
        "ni" -> R.drawable.flag_nicaragua
        "nl" -> R.drawable.flag_netherlands
        "no" -> R.drawable.flag_norway
        "np" -> R.drawable.flag_nepal
        "nr" -> R.drawable.flag_nauru
        "nu" -> R.drawable.flag_niue
        "nz" -> R.drawable.flag_new_zealand
        "om" -> R.drawable.flag_oman
        "pa" -> R.drawable.flag_panama
        "pe" -> R.drawable.flag_peru
        "pf" -> R.drawable.flag_french_polynesia
        "pg" -> R.drawable.flag_papua_new_guinea
        "ph" -> R.drawable.flag_philippines
        "pk" -> R.drawable.flag_pakistan
        "pl" -> R.drawable.flag_poland
        "pm" -> R.drawable.flag_saint_pierre
        "pn" -> R.drawable.flag_pitcairn_islands
        "pr" -> R.drawable.flag_puerto_rico
        "ps" -> R.drawable.flag_palestine
        "pt" -> R.drawable.flag_portugal
        "pw" -> R.drawable.flag_palau
        "py" -> R.drawable.flag_paraguay
        "qa" -> R.drawable.flag_qatar
        "re" -> R.drawable.flag_martinique // no exact flag found
        "ro" -> R.drawable.flag_romania
        "rs" -> R.drawable.flag_serbia // custom
        "ru" -> R.drawable.flag_russian_federation
        "rw" -> R.drawable.flag_rwanda
        "sa" -> R.drawable.flag_saudi_arabia
        "sb" -> R.drawable.flag_soloman_islands
        "sc" -> R.drawable.flag_seychelles
        "sd" -> R.drawable.flag_sudan
        "se" -> R.drawable.flag_sweden
        "sg" -> R.drawable.flag_singapore
        "sh" -> R.drawable.flag_saint_helena // custom
        "si" -> R.drawable.flag_slovenia
        "sk" -> R.drawable.flag_slovakia
        "sl" -> R.drawable.flag_sierra_leone
        "sm" -> R.drawable.flag_san_marino
        "sn" -> R.drawable.flag_senegal
        "so" -> R.drawable.flag_somalia
        "sr" -> R.drawable.flag_suriname
        "ss" -> R.drawable.flag_south_sudan
        "st" -> R.drawable.flag_sao_tome_and_principe
        "sv" -> R.drawable.flag_el_salvador
        "sx" -> R.drawable.flag_sint_maarten
        "sy" -> R.drawable.flag_syria
        "sz" -> R.drawable.flag_swaziland
        "tc" -> R.drawable.flag_turks_and_caicos_islands
        "td" -> R.drawable.flag_chad
        "tg" -> R.drawable.flag_togo
        "th" -> R.drawable.flag_thailand
        "tj" -> R.drawable.flag_tajikistan
        "tk" -> R.drawable.flag_tokelau // custom
        "tl" -> R.drawable.flag_timor_leste
        "tm" -> R.drawable.flag_turkmenistan
        "tn" -> R.drawable.flag_tunisia
        "to" -> R.drawable.flag_tonga
        "tr" -> R.drawable.flag_turkey
        "tt" -> R.drawable.flag_trinidad_and_tobago
        "tv" -> R.drawable.flag_tuvalu
        "tw" -> R.drawable.flag_taiwan
        "tz" -> R.drawable.flag_tanzania
        "ua" -> R.drawable.flag_ukraine
        "ug" -> R.drawable.flag_uganda
        "us" -> R.drawable.flag_united_states_of_america
        "uy" -> R.drawable.flag_uruguay
        "uz" -> R.drawable.flag_uzbekistan
        "va" -> R.drawable.flag_vatican_city
        "vc" -> R.drawable.flag_saint_vicent_and_the_grenadines
        "ve" -> R.drawable.flag_venezuela
        "vg" -> R.drawable.flag_british_virgin_islands
        "vi" -> R.drawable.flag_us_virgin_islands
        "vn" -> R.drawable.flag_vietnam
        "vu" -> R.drawable.flag_vanuatu
        "wf" -> R.drawable.flag_wallis_and_futuna
        "ws" -> R.drawable.flag_samoa
        "xk" -> R.drawable.flag_kosovo
        "ye" -> R.drawable.flag_yemen
        "yt" -> R.drawable.flag_martinique // no exact flag found
        "za" -> R.drawable.flag_south_africa
        "zm" -> R.drawable.flag_zambia
        "zw" -> R.drawable.flag_zimbabwe
        else -> R.drawable.flag_transparent
    }
}
