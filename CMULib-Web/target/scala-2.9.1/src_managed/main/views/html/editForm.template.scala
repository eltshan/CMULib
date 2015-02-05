
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
object editForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Long,Form[Computer],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(id: Long, computerForm: Form[Computer]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.render) }};
Seq(format.raw/*1.42*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.80*/(""" 

"""),_display_(Seq(/*7.2*/main/*7.6*/ {_display_(Seq(format.raw/*7.8*/("""
    
    <h1>Edit computer</h1>
    
    """),_display_(Seq(/*11.6*/form(routes.Application.update(id))/*11.41*/ {_display_(Seq(format.raw/*11.43*/("""
        
        <fieldset>
        
            """),_display_(Seq(/*15.14*/inputText(computerForm("name"), '_label -> "Node name"))),format.raw/*15.69*/("""
            """),_display_(Seq(/*16.14*/inputText(computerForm("lastconnection"), '_label -> "Last connected"))),format.raw/*16.84*/("""
            """),_display_(Seq(/*17.14*/inputText(computerForm("ipaddress"), '_label -> "Discontinued date"))),format.raw/*17.82*/("""
            """),_display_(Seq(/*18.14*/inputText(computerForm("portnum"), '_label -> "Port Number"))),format.raw/*18.74*/("""
       
        </fieldset>
        
        <div class="actions">
            <input type="submit" value="Save this computer" class="btn primary"> or 
            <a href=""""),_display_(Seq(/*24.23*/routes/*24.29*/.Application.list())),format.raw/*24.48*/("""" class="btn">Cancel</a> 
        </div>
        
    """)))})),format.raw/*27.6*/("""
    
    """),_display_(Seq(/*29.6*/form(routes.Application.delete(id), 'class -> "topRight")/*29.63*/ {_display_(Seq(format.raw/*29.65*/("""
        <input type="submit" value="Remove this node" class="btn danger">
    """)))})),format.raw/*31.6*/("""
    
""")))})),format.raw/*33.2*/("""
"""))}
    }
    
    def render(id:Long,computerForm:Form[Computer]) = apply(id,computerForm)
    
    def f:((Long,Form[Computer]) => play.api.templates.Html) = (id,computerForm) => apply(id,computerForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Feb 05 01:11:16 EST 2015
                    SOURCE: /Users/yiranfei/Downloads/play-2.0/samples/java/computer-database/app/views/editForm.scala.html
                    HASH: 50f8b445d7750917ea5f5cfcd71b8c2491697dd4
                    MATRIX: 771->1|896->62|928->86|1007->41|1035->60|1063->140|1096->144|1107->148|1140->150|1213->193|1257->228|1292->230|1374->281|1451->336|1496->350|1588->420|1633->434|1723->502|1768->516|1850->576|2056->751|2071->757|2112->776|2198->831|2239->842|2305->899|2340->901|2451->981|2489->988
                    LINES: 27->1|30->5|30->5|31->1|33->4|34->5|36->7|36->7|36->7|40->11|40->11|40->11|44->15|44->15|45->16|45->16|46->17|46->17|47->18|47->18|53->24|53->24|53->24|56->27|58->29|58->29|58->29|60->31|62->33
                    -- GENERATED --
                */
            