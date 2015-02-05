
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
object createForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Computer],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(computerForm: Form[Computer]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.render) }};
Seq(format.raw/*1.32*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.80*/(""" 

"""),_display_(Seq(/*7.2*/main/*7.6*/ {_display_(Seq(format.raw/*7.8*/("""
    
    <h1>Add a computer</h1>
    
    """),_display_(Seq(/*11.6*/form(routes.Application.save())/*11.37*/ {_display_(Seq(format.raw/*11.39*/("""
        
        <fieldset>
        
            """),_display_(Seq(/*15.14*/inputText(computerForm("name"), '_label -> "Computer name"))),format.raw/*15.73*/("""
            """),_display_(Seq(/*16.14*/inputText(computerForm("lastconnection"), '_label -> "Introduced date"))),format.raw/*16.85*/("""
            """),_display_(Seq(/*17.14*/inputText(computerForm("ipaddress"), '_label -> "Discontinued date"))),format.raw/*17.82*/("""
            """),_display_(Seq(/*18.14*/inputText(computerForm("portnum"), '_label -> "Port Number"))),format.raw/*18.74*/("""

        </fieldset>
        
        <div class="actions">
            <input type="submit" value="Create this computer" class="btn primary"> or 
            <a href=""""),_display_(Seq(/*24.23*/routes/*24.29*/.Application.list())),format.raw/*24.48*/("""" class="btn">Cancel</a> 
        </div>
        
    """)))})),format.raw/*27.6*/("""
    
""")))})),format.raw/*29.2*/("""
"""))}
    }
    
    def render(computerForm:Form[Computer]) = apply(computerForm)
    
    def f:((Form[Computer]) => play.api.templates.Html) = (computerForm) => apply(computerForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Feb 05 01:11:16 EST 2015
                    SOURCE: /Users/yiranfei/Downloads/play-2.0/samples/java/computer-database/app/views/createForm.scala.html
                    HASH: cd8efc394acffc35f27087524c1b9c2c8eb93813
                    MATRIX: 768->1|883->52|915->76|994->31|1022->50|1050->130|1083->134|1094->138|1127->140|1201->184|1241->215|1276->217|1358->268|1439->327|1484->341|1577->412|1622->426|1712->494|1757->508|1839->568|2040->738|2055->744|2096->763|2182->818|2220->825
                    LINES: 27->1|30->5|30->5|31->1|33->4|34->5|36->7|36->7|36->7|40->11|40->11|40->11|44->15|44->15|45->16|45->16|46->17|46->17|47->18|47->18|53->24|53->24|53->24|56->27|58->29
                    -- GENERATED --
                */
            