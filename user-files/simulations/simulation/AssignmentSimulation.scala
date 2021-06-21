package simulation


import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AssignmentSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("https://s2.demo.opensourcecms.com") //s2.demo.opensourcecms.com
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.png""", """.*\.jpeg""", """.*\.gif"""), WhiteList("https://${p_baseURL}/*"))
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.9")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.106 Safari/537.36")

	val headers_0 = Map("upgrade-insecure-requests" -> "1")

	val headers_1 = Map(
		"Origin" -> "https://${p_baseURL}",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_2 = Map(
		"Accept" -> "*/*",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_4 = Map(
		"Accept" -> "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript, */*; q=0.01",
		"X-Requested-With" -> "XMLHttpRequest")

	val headers_8 = Map("Upgrade-Insecure-Requests" -> "1")

    //val uri1 = "https://urldefense.com/v3/__https:/${p_baseURL}/orangehrm/symfony/web/index.php/auth/login__;!!ETvj9GWOF6bnm07gjzU!HnfgbL6jJK7R7SCIKNlaFWqI5hPVchl3AxtoZMkWSkJ7db-srwj-Hkow-SjNhjtILiM$"
    val uri1 = "https://${p_baseURL}/orangehrm/symfony/web/index.php/auth/login"

	  val Think_time = 5
	  val csvFeeder = csv(fileName="C:\\gatling-charts-highcharts-bundle-3.5.1\\user-files\\resources\\data\\Users_details.csv").circular
	  val scn = scenario("AssignmentSimulation")
	        .feed(csvFeeder)
			.forever {
				group(name = "A01_HomePage") {
					exec(http("A01_HomePage")
						.get(uri1)
						.headers(headers_0)
						.check(status.is(200))
						.check(regex(pattern = "name=\"_csrf_token\" value=\"(.*?)\"").saveAs(key="c_csrf_token")))
				}
					.exec { session =>
						println(" CSRF_TOKEN --> " + session("c_csrf_token").as[String])
						session
					}
					.pause(Think_time)

					.group(name = "A02_ClickingOnLogin") {
						exec(http("A02_ClickingOnLogin")
							.post("/orangehrm/symfony/web/index.php/auth/validateCredentials")
							.headers(headers_1)
							.formParam("actionID", "")
							.formParam("hdnUserTimeZoneOffset", "5.5")
							.formParam("installation", "")
							.formParam("_csrf_token", "${c_csrf_token}") //9c61bf847cb20dfae2af79808c7c1d0d
							.formParam("txtUsername", "${p_Username}")
							.formParam("txtPassword", "${p_Password}")
							.formParam("Submit", "LOGIN")
							.resources(http("A02_SubRequest1")
								.get("/orangehrm/symfony/web/index.php/dashboard/employeeDistribution")
								.headers(headers_2),
								http("A02_SubRequest2")
									.get("/orangehrm/symfony/web/index.php/dashboard/pendingLeaveRequests")
									.headers(headers_2),
								http("A02_SubRequest3")
									.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/orangehrmDashboardPlugin/js/flot/jquery.flot.min.js?_=1624203578215")
									.headers(headers_4),
								http("A02_SubRequest4")
									.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/orangehrmDashboardPlugin/js/flot/jquery.flot.pie.min.js?_=1624203578369")
									.headers(headers_4),
								http("A02_SubRequest5")
									.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/orangehrmDashboardPlugin/js/flot/JUMFlot.min.js?_=1624203578527")
									.headers(headers_4),
								http("A02_SubRequest6")
									.get("/orangehrm/symfony/web/webres_5bdfdad33dec87.24121780/orangehrmDashboardPlugin/js/graph-visualizer/pie-chart.js?_=1624203578694")
									.headers(headers_4)))
						      
					}
					.pause(Think_time)

					.group(name = "A03_ClickingOnAdminModule") {
						exec(http("A03_ClickingOnAdminModule")
							.get("/orangehrm/symfony/web/index.php/admin/viewAdminModule")
							.headers(headers_8)
							.check(status.is(200)))
					}
					.pause(Think_time)

					.group(name = "A04_ClickingOnTimeModule")
					{
						exec(http("A04_ClickingOnTimeModule")
							.get("/orangehrm/symfony/web/index.php/time/viewTimeModule")
							.headers(headers_8)
							.check(status.is(200)))
					}
					.pause(Think_time)

					.group(name = "A05_ClickingOnLogout")
					{
						exec(http("A05_ClickingOnLogout")
							.get("/orangehrm/symfony/web/index.php/auth/logout")
							.headers(headers_8)
							.check(status.is(200)))
					}
			}

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol).maxDuration(duration = 90 seconds)
}