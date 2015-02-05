
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.api.templates.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import com.avaje.ebean._
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object list extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Page[Computer],String,String,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(currentPage: Page[Computer], currentSortBy: String, currentOrder: String, currentFilter: String):play.api.templates.Html = {
        _display_ {
def /*32.2*/header/*32.8*/(key:String, title:String):play.api.templates.Html = {_display_(

Seq(format.raw/*32.38*/("""
    <th class=""""),_display_(Seq(/*33.17*/key/*33.20*/.replace(".","_"))),format.raw/*33.37*/(""" header """),_display_(Seq(/*33.46*/if(currentSortBy == key){/*33.72*/{if(currentOrder == "asc") "headerSortDown" else "headerSortUp"}})),format.raw/*33.136*/("""">
        <a href=""""),_display_(Seq(/*34.19*/link(0, key))),format.raw/*34.31*/("""">"""),_display_(Seq(/*34.34*/title)),format.raw/*34.39*/("""</a>
    </th>
""")))};def /*6.2*/link/*6.6*/(newPage:Int, newSortBy:String) = {{
    
    var sortBy = currentSortBy
    var order = currentOrder
    
    if(newSortBy != null) {
        sortBy = newSortBy
        if(currentSortBy == newSortBy) {
            if(currentOrder == "asc") {
                order = "desc"
            } else {
                order = "asc"
            }
        } else {
            order = "asc"
        }
    }
    
    // Generate the link
    routes.Application.list(newPage, sortBy, order, currentFilter)
    
}};
Seq(format.raw/*1.99*/("""

"""),format.raw/*5.42*/("""
"""),format.raw/*27.2*/("""

"""),format.raw/*31.37*/("""
"""),format.raw/*36.2*/("""

"""),_display_(Seq(/*38.2*/main/*38.6*/ {_display_(Seq(format.raw/*38.8*/("""
    
    <h1 id="homeTitle">"""),_display_(Seq(/*40.25*/Messages("computers.list.title", currentPage.getTotalRowCount))),format.raw/*40.87*/("""</h1>

    """),_display_(Seq(/*42.6*/if(flash.containsKey("success"))/*42.38*/ {_display_(Seq(format.raw/*42.40*/("""
        <div class="alert-message warning">
            <strong>Done!</strong> """),_display_(Seq(/*44.37*/flash/*44.42*/.get("success"))),format.raw/*44.57*/("""
        </div>
    """)))})),format.raw/*46.6*/(""" 

    <div id="actions">
        
        <form action=""""),_display_(Seq(/*50.24*/link(0, "name"))),format.raw/*50.39*/("""" method="GET">
            <input type="search" id="searchbox" name="f" value=""""),_display_(Seq(/*51.66*/currentFilter)),format.raw/*51.79*/("""" placeholder="Filter by computer name...">
            <input type="submit" id="searchsubmit" value="Filter by name" class="btn primary">
        </form>
        
        <a class="btn success" id="add" href=""""),_display_(Seq(/*55.48*/routes/*55.54*/.Application.create())),format.raw/*55.75*/("""">Register a new node</a>
        
    </div>
    
    """),_display_(Seq(/*59.6*/if(currentPage.getTotalRowCount == 0)/*59.43*/ {_display_(Seq(format.raw/*59.45*/("""
        
        <div class="well">
            <em>Nothing to display</em>
        </div>
        
    """)))}/*65.7*/else/*65.12*/{_display_(Seq(format.raw/*65.13*/("""
        
        <table class="computers zebra-striped">
            <thead>
                <tr>
                    """),_display_(Seq(/*70.22*/header("name", "Node name"))),format.raw/*70.49*/("""
                    """),_display_(Seq(/*71.22*/header("lastconnection", "Last Connection"))),format.raw/*71.65*/("""
                    """),_display_(Seq(/*72.22*/header("ipaddress", "IP Address"))),format.raw/*72.55*/("""
                    """),_display_(Seq(/*73.22*/header("portnum", "Port Num."))),format.raw/*73.52*/("""
                </tr>
            </thead>
            <tbody>

                """),_display_(Seq(/*78.18*/for(computer <- currentPage.getList) yield /*78.54*/ {_display_(Seq(format.raw/*78.56*/("""
                    <tr>
                        <td><a href=""""),_display_(Seq(/*80.39*/routes/*80.45*/.Application.edit(computer.id))),format.raw/*80.75*/("""">"""),_display_(Seq(/*80.78*/computer/*80.86*/.name)),format.raw/*80.91*/("""</a></td>
                        <td>
                            """),_display_(Seq(/*82.30*/if(computer.lastconnection == null)/*82.65*/ {_display_(Seq(format.raw/*82.67*/("""
                                <em>-</em>
                            """)))}/*84.31*/else/*84.36*/{_display_(Seq(format.raw/*84.37*/("""
                                """),_display_(Seq(/*85.34*/computer/*85.42*/.lastconnection)),format.raw/*85.57*/("""
                            """)))})),format.raw/*86.30*/("""
                        </td>
                        <td>
                            """),_display_(Seq(/*89.30*/if(computer.ipaddress == null)/*89.60*/ {_display_(Seq(format.raw/*89.62*/("""
                                <em>-</em>
                            """)))}/*91.31*/else/*91.36*/{_display_(Seq(format.raw/*91.37*/("""
                                """),_display_(Seq(/*92.34*/computer/*92.42*/.ipaddress)),format.raw/*92.52*/("""
                            """)))})),format.raw/*93.30*/("""
                        </td>
                        <td>
                            """),_display_(Seq(/*96.30*/if(computer.portnum == null)/*96.58*/ {_display_(Seq(format.raw/*96.60*/("""
                                <em>-</em>
                            """)))}/*98.31*/else/*98.36*/{_display_(Seq(format.raw/*98.37*/("""
                                """),_display_(Seq(/*99.34*/computer/*99.42*/.portnum)),format.raw/*99.50*/("""
                            """)))})),format.raw/*100.30*/("""
                        </td>
                    </tr>
                """)))})),format.raw/*103.18*/("""

            </tbody>
        </table>

        <div id="pagination" class="pagination">
            <ul>
                """),_display_(Seq(/*110.18*/if(currentPage.hasPrev)/*110.41*/ {_display_(Seq(format.raw/*110.43*/("""
                    <li class="prev">
                        <a href=""""),_display_(Seq(/*112.35*/link(currentPage.getPageIndex - 1, null))),format.raw/*112.75*/("""">&larr; Previous</a>
                    </li>
                """)))}/*114.19*/else/*114.24*/{_display_(Seq(format.raw/*114.25*/("""
                    <li class="prev disabled">
                        <a>&larr; Previous</a>
                    </li>
                """)))})),format.raw/*118.18*/("""
                <li class="current">
                    <a>Displaying """),_display_(Seq(/*120.36*/currentPage/*120.47*/.getDisplayXtoYofZ(" to "," of "))),format.raw/*120.80*/("""</a>
                </li>
                """),_display_(Seq(/*122.18*/if(currentPage.hasNext)/*122.41*/ {_display_(Seq(format.raw/*122.43*/("""
                    <li class="next">
                        <a href=""""),_display_(Seq(/*124.35*/link(currentPage.getPageIndex + 1, null))),format.raw/*124.75*/("""">Next &rarr;</a>
                    </li>
                """)))}/*126.19*/else/*126.24*/{_display_(Seq(format.raw/*126.25*/("""
                    <li class="next disabled">
                        <a>Next &rarr;</a>
                    </li>
                """)))})),format.raw/*130.18*/("""
            </ul>
        </div>
        
    """)))})),format.raw/*134.6*/("""
        
""")))})),format.raw/*136.2*/("""

            
"""))}
    }
    
    def render(currentPage:Page[Computer],currentSortBy:String,currentOrder:String,currentFilter:String) = apply(currentPage,currentSortBy,currentOrder,currentFilter)
    
    def f:((Page[Computer],String,String,String) => play.api.templates.Html) = (currentPage,currentSortBy,currentOrder,currentFilter) => apply(currentPage,currentSortBy,currentOrder,currentFilter)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Feb 05 01:39:46 EST 2015
                    SOURCE: /Users/yiranfei/Downloads/play-2.0/samples/java/computer-database/app/views/list.scala.html
                    HASH: a00750198204ddecaeafdbefd0e47faffa0cd91f
                    MATRIX: 783->1|941->844|955->850|1044->880|1092->897|1104->900|1143->917|1183->926|1217->952|1305->1016|1357->1037|1391->1049|1425->1052|1452->1057|1490->227|1501->231|2027->98|2056->225|2084->732|2114->842|2142->1073|2175->1076|2187->1080|2221->1082|2282->1112|2366->1174|2408->1186|2449->1218|2484->1220|2596->1301|2610->1306|2647->1321|2699->1342|2788->1400|2825->1415|2937->1496|2972->1509|3214->1720|3229->1726|3272->1747|3358->1803|3404->1840|3439->1842|3563->1949|3576->1954|3610->1955|3761->2075|3810->2102|3863->2124|3928->2167|3981->2189|4036->2222|4089->2244|4141->2274|4254->2356|4306->2392|4341->2394|4436->2458|4451->2464|4503->2494|4537->2497|4554->2505|4581->2510|4680->2578|4724->2613|4759->2615|4851->2689|4864->2694|4898->2695|4963->2729|4980->2737|5017->2752|5079->2782|5199->2871|5238->2901|5273->2903|5365->2977|5378->2982|5412->2983|5477->3017|5494->3025|5526->3035|5588->3065|5708->3154|5745->3182|5780->3184|5872->3258|5885->3263|5919->3264|5984->3298|6001->3306|6031->3314|6094->3344|6201->3418|6357->3542|6390->3565|6426->3567|6531->3640|6594->3680|6679->3746|6693->3751|6728->3752|6899->3890|7004->3963|7025->3974|7081->4007|7157->4051|7190->4074|7226->4076|7331->4149|7394->4189|7475->4251|7489->4256|7524->4257|7691->4391|7771->4439|7814->4450
                    LINES: 27->1|29->32|29->32|31->32|32->33|32->33|32->33|32->33|32->33|32->33|33->34|33->34|33->34|33->34|35->6|35->6|57->1|59->5|60->27|62->31|63->36|65->38|65->38|65->38|67->40|67->40|69->42|69->42|69->42|71->44|71->44|71->44|73->46|77->50|77->50|78->51|78->51|82->55|82->55|82->55|86->59|86->59|86->59|92->65|92->65|92->65|97->70|97->70|98->71|98->71|99->72|99->72|100->73|100->73|105->78|105->78|105->78|107->80|107->80|107->80|107->80|107->80|107->80|109->82|109->82|109->82|111->84|111->84|111->84|112->85|112->85|112->85|113->86|116->89|116->89|116->89|118->91|118->91|118->91|119->92|119->92|119->92|120->93|123->96|123->96|123->96|125->98|125->98|125->98|126->99|126->99|126->99|127->100|130->103|137->110|137->110|137->110|139->112|139->112|141->114|141->114|141->114|145->118|147->120|147->120|147->120|149->122|149->122|149->122|151->124|151->124|153->126|153->126|153->126|157->130|161->134|163->136
                    -- GENERATED --
                */
            