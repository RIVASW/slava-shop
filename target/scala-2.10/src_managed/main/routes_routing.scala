// @SOURCE:C:/PlayProj/simple-rest-scala/conf/routes
// @HASH:9b76ede885c33f6365436a5fb20e76e61b5964b6
// @DATE:Sun Dec 06 18:16:23 NOVT 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:5
private[this] lazy val controllers_Application_listProducts0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("products/"),DynamicPart("article", """.+""",false))))
private[this] lazy val controllers_Application_listProducts0_invoker = createInvoker(
controllers.Application.listProducts(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "listProducts", Seq(classOf[String]),"GET", """""", Routes.prefix + """products/$article<.+>"""))
        

// @LINE:6
private[this] lazy val controllers_Authenticator_authenticate1_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("authenticate"))))
private[this] lazy val controllers_Authenticator_authenticate1_invoker = createInvoker(
controllers.Authenticator.authenticate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Authenticator", "authenticate", Nil,"POST", """""", Routes.prefix + """authenticate"""))
        

// @LINE:9
private[this] lazy val controllers_Assets_versioned2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_versioned2_invoker = createInvoker(
controllers.Assets.versioned(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "versioned", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """products/$article<.+>""","""controllers.Application.listProducts(article:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """authenticate""","""controllers.Authenticator.authenticate"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.versioned(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:5
case controllers_Application_listProducts0_route(params) => {
   call(params.fromPath[String]("article", None)) { (article) =>
        controllers_Application_listProducts0_invoker.call(controllers.Application.listProducts(article))
   }
}
        

// @LINE:6
case controllers_Authenticator_authenticate1_route(params) => {
   call { 
        controllers_Authenticator_authenticate1_invoker.call(controllers.Authenticator.authenticate)
   }
}
        

// @LINE:9
case controllers_Assets_versioned2_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_versioned2_invoker.call(controllers.Assets.versioned(path, file))
   }
}
        
}

}
     