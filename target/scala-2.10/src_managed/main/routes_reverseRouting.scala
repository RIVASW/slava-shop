// @SOURCE:C:/PlayProj/simple-rest-scala/conf/routes
// @HASH:9b76ede885c33f6365436a5fb20e76e61b5964b6
// @DATE:Sun Dec 06 18:16:23 NOVT 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:9
// @LINE:6
// @LINE:5
package controllers {

// @LINE:6
class ReverseAuthenticator {


// @LINE:6
def authenticate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "authenticate")
}
                        

}
                          

// @LINE:9
class ReverseAssets {


// @LINE:9
def versioned(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:5
class ReverseApplication {


// @LINE:5
def listProducts(article:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "products/" + implicitly[PathBindable[String]].unbind("article", article))
}
                        

}
                          
}
                  


// @LINE:9
// @LINE:6
// @LINE:5
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:6
class ReverseAuthenticator {


// @LINE:6
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authenticator.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "authenticate"})
      }
   """
)
                        

}
              

// @LINE:9
class ReverseAssets {


// @LINE:9
def versioned : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.versioned",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:5
class ReverseApplication {


// @LINE:5
def listProducts : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.listProducts",
   """
      function(article) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "products/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("article", article)})
      }
   """
)
                        

}
              
}
        


// @LINE:9
// @LINE:6
// @LINE:5
package controllers.ref {


// @LINE:6
class ReverseAuthenticator {


// @LINE:6
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authenticator.authenticate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Authenticator", "authenticate", Seq(), "POST", """""", _prefix + """authenticate""")
)
                      

}
                          

// @LINE:9
class ReverseAssets {


// @LINE:9
def versioned(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.versioned(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "versioned", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:5
class ReverseApplication {


// @LINE:5
def listProducts(article:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.listProducts(article), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "listProducts", Seq(classOf[String]), "GET", """""", _prefix + """products/$article<.+>""")
)
                      

}
                          
}
        
    