
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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(content: Html):play.api.templates.Html = {
        _display_ {

Seq(format.raw/*1.17*/("""

<!DOCTYPE html>
<html>
    <head>
        <title>Computers database</title>
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq(/*7.70*/routes/*7.76*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*7.119*/(""""> 
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq(/*8.70*/routes/*8.76*/.Assets.at("stylesheets/main.css"))),format.raw/*8.110*/(""""> 
    </head>
    <body>
<header class="topbar">        
<h1 class="fill">
                <a href="index.html">
                    Back to console
                </a>
            </h1>
        </header>
        
        <section id="main">
            """),_display_(Seq(/*20.14*/content)),format.raw/*20.21*/("""
        </section>
        
    </body>
</html>
"""))}
    }
    
    def render(content:Html) = apply(content)
    
    def f:((Html) => play.api.templates.Html) = (content) => apply(content)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Feb 04 19:38:58 EST 2015
                    SOURCE: /Users/yiranfei/Downloads/play-2.0/samples/java/computer-database/app/views/main.scala.html
                    HASH: 4480d9ca9e0162d315c425eba5fa1632b9b32cca
                    MATRIX: 752->1|839->16|1016->163|1030->169|1095->212|1198->285|1212->291|1268->325|1557->583|1586->590
                    LINES: 27->1|30->1|36->7|36->7|36->7|37->8|37->8|37->8|49->20|49->20
                    -- GENERATED --
                */
            