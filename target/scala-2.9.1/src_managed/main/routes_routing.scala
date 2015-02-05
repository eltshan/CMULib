// @SOURCE:/Users/yiranfei/Downloads/play-2.0/samples/java/computer-database/conf/routes
// @HASH:49071411321da7e067801195cf6311b74eb0699c
// @DATE:Wed Feb 04 19:05:57 EST 2015

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {


// @LINE:6
val controllers_Assets_at0 = Route("GET", PathPattern(List(StaticPart("/index.html"))))
                    

// @LINE:9
val controllers_Application_list1 = Route("GET", PathPattern(List(StaticPart("/computers"))))
                    

// @LINE:12
val controllers_Application_create2 = Route("GET", PathPattern(List(StaticPart("/computers/new"))))
                    

// @LINE:13
val controllers_Application_save3 = Route("POST", PathPattern(List(StaticPart("/computers"))))
                    

// @LINE:16
val controllers_Application_edit4 = Route("GET", PathPattern(List(StaticPart("/computers/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:17
val controllers_Application_update5 = Route("POST", PathPattern(List(StaticPart("/computers/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:20
val controllers_Application_delete6 = Route("POST", PathPattern(List(StaticPart("/computers/"),DynamicPart("id", """[^/]+"""),StaticPart("/delete"))))
                    

// @LINE:23
val controllers_Application_index7 = Route("GET", PathPattern(List(StaticPart("/"))))
                    

// @LINE:24
val controllers_Assets_at8 = Route("GET", PathPattern(List(StaticPart("/"),DynamicPart("file", """.+"""))))
                    
def documentation = List(("""GET""","""/index.html""","""controllers.Assets.at(path:String = "/public", file:String = "index.html")"""),("""GET""","""/computers""","""controllers.Application.list(p:Int ?= 0, s:String ?= "name", o:String ?= "asc", f:String ?= "")"""),("""GET""","""/computers/new""","""controllers.Application.create()"""),("""POST""","""/computers""","""controllers.Application.save()"""),("""GET""","""/computers/$id<[^/]+>""","""controllers.Application.edit(id:Long)"""),("""POST""","""/computers/$id<[^/]+>""","""controllers.Application.update(id:Long)"""),("""POST""","""/computers/$id<[^/]+>/delete""","""controllers.Application.delete(id:Long)"""),("""GET""","""/""","""controllers.Application.index()"""),("""GET""","""/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""))
             
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Assets_at0(params) => {
   call(Param[String]("path", Right("/public")), Param[String]("file", Right("index.html"))) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    

// @LINE:9
case controllers_Application_list1(params) => {
   call(params.fromQuery[Int]("p", Some(0)), params.fromQuery[String]("s", Some("name")), params.fromQuery[String]("o", Some("asc")), params.fromQuery[String]("f", Some(""))) { (p, s, o, f) =>
        invokeHandler(_root_.controllers.Application.list(p, s, o, f), HandlerDef(this, "controllers.Application", "list", Seq(classOf[Int], classOf[String], classOf[String], classOf[String])))
   }
}
                    

// @LINE:12
case controllers_Application_create2(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.create(), HandlerDef(this, "controllers.Application", "create", Nil))
   }
}
                    

// @LINE:13
case controllers_Application_save3(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.save(), HandlerDef(this, "controllers.Application", "save", Nil))
   }
}
                    

// @LINE:16
case controllers_Application_edit4(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Application.edit(id), HandlerDef(this, "controllers.Application", "edit", Seq(classOf[Long])))
   }
}
                    

// @LINE:17
case controllers_Application_update5(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Application.update(id), HandlerDef(this, "controllers.Application", "update", Seq(classOf[Long])))
   }
}
                    

// @LINE:20
case controllers_Application_delete6(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Application.delete(id), HandlerDef(this, "controllers.Application", "delete", Seq(classOf[Long])))
   }
}
                    

// @LINE:23
case controllers_Application_index7(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil))
   }
}
                    

// @LINE:24
case controllers_Assets_at8(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    
}
    
}
                