package simulation


import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class OpenSourceCmsSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("https://${p_baseURL}")
		.inferHtmlResources(BlackList(), WhiteList())

	val headers_0 = Map(
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-US,en;q=0.9",
		"upgrade-insecure-requests" -> "1",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.106 Safari/537.36")

	val headers_1 = Map(
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.106 Safari/537.36")

	val headers_25 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en-US,en;q=0.9",
		"Cache-Control" -> "max-age=0",
		"Origin" -> "https://${p_baseURL}",
		"Upgrade-Insecure-Requests" -> "1",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.106 Safari/537.36")

	val headers_55 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en-US,en;q=0.9",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.106 Safari/537.36",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_57 = Map(
		"Accept" -> "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript, */*; q=0.01",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en-US,en;q=0.9",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.106 Safari/537.36",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_63 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en-US,en;q=0.9",
		"Upgrade-Insecure-Requests" -> "1",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.106 Safari/537.36")

      val uri2 = "https://${p_baseURL}/orangehrm/symfony/web/index.php/auth/login"
	  val Think_time = 5
	  val csvFeeder = csv(fileName="C:\\gatling-charts-highcharts-bundle-3.5.1\\user-files\\resources\\data\\Users_details.csv").circular
	  //val csvFeeder = csv("data/Users_details.csv").circular
	  val scn = scenario("OpenSourceCmsSimulation")
	  .feed(csvFeeder)		
		.exec(http("A01_HomePage")
			.get(uri2)
			.headers(headers_0)
			.check(status.is(200))
			.check(regex(pattern = "name=\"_csrf_token\" value=\"(.*?)\"").saveAs(key="c_csrf_token"))
			.resources(http("request_1")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/css/reset.css")
			.headers(headers_1),
            http("request_2")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/css/tipTip.css")
			.headers(headers_1),
            http("request_3")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/css/jquery/jquery-ui-1.8.21.custom.css")
			.headers(headers_1),
            http("request_4")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/css/jquery/jquery.autocomplete.css")
			.headers(headers_1),
            http("request_5")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/css/main.css")
			.headers(headers_1),
            http("request_6")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/validate/jquery.validate.js")
			.headers(headers_1),
            http("request_7")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.ui.core.js")
			.headers(headers_1),
            http("request_8")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.autocomplete.js")
			.headers(headers_1),
            http("request_9")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/orangehrm.autocomplete.js")
			.headers(headers_1),
            http("request_10")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.form.js")
			.headers(headers_1),
            http("request_11")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.ui.datepicker.js")
			.headers(headers_1),
            http("request_12")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.tipTip.minified.js")
			.headers(headers_1),
            http("request_13")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/bootstrap-modal.js")
			.headers(headers_1),
            http("request_14")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.clickoutside.js")
			.headers(headers_1),
            http("request_15")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery-1.7.2.min.js")
			.headers(headers_1),
            http("request_16")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/orangehrm.validate.js")
			.headers(headers_1),
            http("request_17")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/archive.js")
			.headers(headers_1),
            http("request_18")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/login/logo.png")
			.headers(headers_1),
            http("request_19")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/login/linkedin.png")
			.headers(headers_1),
            http("request_20")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/login/facebook.png")
			.headers(headers_1),
            http("request_21")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/login/twiter.png")
			.headers(headers_1),
            http("request_22")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/login/youtube.png")
			.headers(headers_1),
            http("request_23")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/login/login.png")
			.headers(headers_1),
            http("request_24")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/login/Login_button.png")
			.headers(headers_1)))
		.pause(Think_time)
			.exec { session =>
				println(" CSRF_TOKEN --> " + session("c_csrf_token").as[String])
				session
			}
			.exec(http("A02_Login")
			.post("/orangehrm/symfony/web/index.php/auth/validateCredentials")
			.headers(headers_25)
			.check(status.is(200))
			.formParam("actionID", "")
			.formParam("hdnUserTimeZoneOffset", "5.5")
			.formParam("installation", "")
			.formParam("_csrf_token", "${c_csrf_token}")
			.formParam("txtUsername", "${p_Username}")
			.formParam("txtPassword", "${p_Password}")
			.formParam("Submit", "LOGIN")
			.resources(http("request_26")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery-1.7.2.min.js")
			.headers(headers_1),
            http("request_27")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/validate/jquery.validate.js")
			.headers(headers_1),
            http("request_28")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.ui.core.js")
			.headers(headers_1),
            http("request_29")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.autocomplete.js")
			.headers(headers_1),
            http("request_30")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/orangehrm.autocomplete.js")
			.headers(headers_1),
            http("request_31")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.ui.datepicker.js")
			.headers(headers_1),
            http("request_32")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.form.js")
			.headers(headers_1),
            http("request_33")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.tipTip.minified.js")
			.headers(headers_1),
            http("request_34")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/bootstrap-modal.js")
			.headers(headers_1),
            http("request_35")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.clickoutside.js")
			.headers(headers_1),
            http("request_36")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/orangehrm.validate.js")
			.headers(headers_1),
            http("request_37")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/archive.js")
			.headers(headers_1),
            http("request_38")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/css/reset.css")
			.headers(headers_1),
            http("request_39")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/css/tipTip.css")
			.headers(headers_1),
            http("request_40")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/css/jquery/jquery-ui-1.8.21.custom.css")
			.headers(headers_1),
            http("request_41")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/css/jquery/jquery.autocomplete.css")
			.headers(headers_1),
            http("request_42")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/css/main.css")
			.headers(headers_1),
            http("request_43")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/orangehrmBeaconPlugin/css/_beaconAbout.css")
			.headers(headers_1),
            http("request_44")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/orangehrmDashboardPlugin/css/orangehrmDashboardPlugin.css")
			.headers(headers_1),
            http("request_45")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/logo.png")
			.headers(headers_1),
            http("request_46")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/orangehrmLeavePlugin/images/ApplyLeave.png")
			.headers(headers_1),
            http("request_47")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/orangehrmLeavePlugin/images/MyLeave.png")
			.headers(headers_1),
            http("request_48")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/orangehrmTimePlugin/images/MyTimesheet.png")
			.headers(headers_1),
            http("request_49")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/welcome-down.png")
			.headers(headers_1),
            http("request_50")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/nav-bg.png")
			.headers(headers_1),
            http("request_51")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/sub-nav-arrow-n.png")
			.headers(headers_1),
            http("request_52")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/sub-nav.png")
			.headers(headers_1),
            http("request_53")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/h1-bg.png")
			.headers(headers_1),
            http("request_54")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/orangehrmDashboardPlugin/images/loading.gif")
			.headers(headers_1),
            http("request_55")
			.get("/orangehrm/symfony/web/index.php/dashboard/employeeDistribution")
			.headers(headers_55),
            http("request_56")
			.get("/orangehrm/symfony/web/index.php/dashboard/pendingLeaveRequests")
			.headers(headers_55),
            http("request_57")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/orangehrmDashboardPlugin/js/flot/jquery.flot.min.js?_=1624203578215")
			.headers(headers_57),
            http("request_58")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/orangehrmDashboardPlugin/js/flot/jquery.flot.pie.min.js?_=1624203578369")
			.headers(headers_57),
            http("request_59")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/orangehrmDashboardPlugin/js/flot/JUMFlot.min.js?_=1624203578527")
			.headers(headers_57),
            http("request_60")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/orangehrmDashboardPlugin/js/graph-visualizer/pie-chart.js?_=1624203578694")
			.headers(headers_57)))
		//.pause(4)
		.exec(http("request_61")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/top-nav-selected1.png")
			.headers(headers_1)
			.resources(http("request_62")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/sub-nav-arrow-s.png")
			.headers(headers_1)))
		.pause(Think_time)
		
		.exec(http("A03_ClickingOnAdminModule")
			.get("/orangehrm/symfony/web/index.php/admin/viewAdminModule")
			.headers(headers_63)
			.check(status.is(200))
			.resources(http("request_64")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery-1.7.2.min.js")
			.headers(headers_1),
            http("request_65")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/validate/jquery.validate.js")
			.headers(headers_1),
            http("request_66")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.ui.core.js")
			.headers(headers_1),
            http("request_67")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.autocomplete.js")
			.headers(headers_1),
            http("request_68")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/orangehrm.autocomplete.js")
			.headers(headers_1),
            http("request_69")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.ui.datepicker.js")
			.headers(headers_1),
            http("request_70")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.form.js")
			.headers(headers_1),
            http("request_71")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.tipTip.minified.js")
			.headers(headers_1),
            http("request_72")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/bootstrap-modal.js")
			.headers(headers_1),
            http("request_73")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.clickoutside.js")
			.headers(headers_1),
            http("request_74")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/orangehrm.validate.js")
			.headers(headers_1),
            http("request_75")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/archive.js")
			.headers(headers_1),
            http("request_76")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/logo.png")
			.headers(headers_1),
            http("request_77")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/css/reset.css")
			.headers(headers_1),
            http("request_78")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/css/tipTip.css")
			.headers(headers_1),
            http("request_79")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/css/jquery/jquery-ui-1.8.21.custom.css")
			.headers(headers_1),
            http("request_80")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/css/jquery/jquery.autocomplete.css")
			.headers(headers_1),
            http("request_81")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/css/main.css")
			.headers(headers_1),
            http("request_82")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/orangehrmAdminPlugin/js/viewSystemUserSuccess.js")
			.headers(headers_1),
            http("request_83")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/orangehrmCorePlugin/css/_ohrmList.css")
			.headers(headers_1),
            http("request_84")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/orangehrmBeaconPlugin/css/_beaconAbout.css")
			.headers(headers_1),
            http("request_85")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/orangehrmCorePlugin/js/_ohrmList.js")
			.headers(headers_1),
            http("request_86")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/welcome-down.png")
			.headers(headers_1),
            http("request_87")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/nav-bg.png")
			.headers(headers_1),
            http("request_88")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/sub-nav.png")
			.headers(headers_1),
            http("request_89")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/sub-nav-arrow-s.png")
			.headers(headers_1),
            http("request_90")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/sub-nav-arrow-n.png")
			.headers(headers_1),
            http("request_91")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/sub-nav-arrow.png")
			.headers(headers_1),
            http("request_92")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/h1-bg.png")
			.headers(headers_1),
            http("request_93")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/toggle-down.png")
			.headers(headers_1),
            http("request_94")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/tablesorter-bg.png")
			.headers(headers_1)))
		//.pause(3)
		.exec(http("request_95")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/top-nav-selected1.png")
			.headers(headers_1))
		.pause(Think_time)
		.exec(http("A04_ClickingOnTimeModule")
			.get("/orangehrm/symfony/web/index.php/time/viewTimeModule")
			.headers(headers_63)
			.check(status.is(200))
			.resources(http("request_97")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/css/reset.css")
			.headers(headers_1),
            http("request_98")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/css/tipTip.css")
			.headers(headers_1),
            http("request_99")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/css/jquery/jquery-ui-1.8.21.custom.css")
			.headers(headers_1),
            http("request_100")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/css/jquery/jquery.autocomplete.css")
			.headers(headers_1),
            http("request_101")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/css/main.css")
			.headers(headers_1),
            http("request_102")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery-1.7.2.min.js")
			.headers(headers_1),
            http("request_103")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/validate/jquery.validate.js")
			.headers(headers_1),
            http("request_104")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.ui.core.js")
			.headers(headers_1),
            http("request_105")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.autocomplete.js")
			.headers(headers_1),
            http("request_106")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/orangehrm.autocomplete.js")
			.headers(headers_1),
            http("request_107")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.ui.datepicker.js")
			.headers(headers_1),
            http("request_108")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.form.js")
			.headers(headers_1),
            http("request_109")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.tipTip.minified.js")
			.headers(headers_1),
            http("request_110")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/bootstrap-modal.js")
			.headers(headers_1),
            http("request_111")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/jquery/jquery.clickoutside.js")
			.headers(headers_1),
            http("request_112")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/orangehrm.validate.js")
			.headers(headers_1),
            http("request_113")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/js/archive.js")
			.headers(headers_1),
            http("request_114")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/orangehrmBeaconPlugin/css/_beaconAbout.css")
			.headers(headers_1),
            http("request_115")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/logo.png")
			.headers(headers_1),
            http("request_116")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/orangehrmTimePlugin/js/viewEmployeeTimesheet.js")
			.headers(headers_1),
            http("request_117")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/welcome-down.png"),
            http("request_118")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/nav-bg.png"),
            http("request_119")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/sub-nav-arrow-n.png"),
            http("request_120")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/sub-nav.png"),
            http("request_121")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/sub-nav-arrow-s.png"),
            http("request_122")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/sub-nav-arrow.png"),
            http("request_123")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/h1-bg.png")))
		//.pause(1)
		.exec(http("request_124")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/sub-nav.png")
			.resources(http("request_125")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/sub-nav.png"),
            http("request_126")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/top-nav-selected1.png"),
            http("request_127")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/top-nav-selected1.png")))
		//.pause(4)
		.exec(http("request_128")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/welcome-down.png")
			.resources(http("request_129")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/welcome-up.png")
			.headers(headers_1)))
		.pause(Think_time)
		
		.exec(http("A05_ClickingOnLogout")
			.get("/orangehrm/symfony/web/index.php/auth/logout")
			.headers(headers_63)
			.check(status.is(200))
			.resources(http("request_131")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/login/login.png")
			.headers(headers_1),
            http("request_132")
			.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/themes/default/images/login/Login_button.png")
			.headers(headers_1)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol).maxDuration(duration = 60 seconds)
}