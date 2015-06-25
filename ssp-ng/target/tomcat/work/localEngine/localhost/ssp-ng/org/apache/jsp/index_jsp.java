package org.apache.jsp;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
        implements org.apache.jasper.runtime.JspSourceDependent {

    private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

    private static java.util.List _jspx_dependants;

    private javax.el.ExpressionFactory _el_expressionfactory;
    private org.apache.AnnotationProcessor _jsp_annotationprocessor;

    public Object getDependants() {
        return _jspx_dependants;
    }

    public void _jspInit() {
        _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
    }

    public void _jspDestroy() {
    }

    public void _jspService(HttpServletRequest request, HttpServletResponse response)
            throws java.io.IOException, ServletException {

        PageContext pageContext = null;
        HttpSession session = null;
        ServletContext application = null;
        ServletConfig config = null;
        JspWriter out = null;
        Object page = this;
        JspWriter _jspx_out = null;
        PageContext _jspx_page_context = null;


        try {
            response.setContentType("text/html");
            pageContext = _jspxFactory.getPageContext(this, request, response,
                    null, true, 8192, true);
            _jspx_page_context = pageContext;
            application = pageContext.getServletContext();
            config = pageContext.getServletConfig();
            session = pageContext.getSession();
            out = pageContext.getOut();
            _jspx_out = out;

            out.write("<!doctype html>\n");
            out.write("<html lang=\"en\" ng-app=\"shopping-list\">\n");
            out.write("<head>\n");
            out.write("    <meta charset=\"utf-8\">\n");
            out.write("    <title>Shopping List</title>\n");
            out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
            out.write("    <link href=\"lib/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\n");
            out.write("    <link rel=\"stylesheet\" href=\"css/app.css\"/>\n");
            out.write("</head>\n");
            out.write("<body ng-controller=\"HomeController\">\n");
            out.write("\n");
            out.write("<div class=\"container\">\n");
            out.write("    <div class=\"header\">\n");
            out.write("        <ul class=\"nav nav-pills pull-right\">\n");
            out.write("            <li class=\"active\"><a ng-href=\"#\">Home</a></li>\n");
            out.write("            <li><a ng-href=\"#/about\">About</a></li>\n");
            out.write("            <li><a ng-href=\"#\">Contact</a></li>\n");
            out.write("        </ul>\n");
            out.write("        <h3 class=\"text-muted\">ssp-ng</h3>\n");
            out.write("    </div>\n");
            out.write("\n");
            out.write("\n");
            out.write("    <div class=\"col-lg-2\">\n");
            out.write("        <div class=\"btn-wrapper\">\n");
            out.write("            <a ng-click=\"createList();\" class=\"btn btn-block btn-warning\">Nouvelle Liste</a>\n");
            out.write("        </div>\n");
            out.write("        <div class=\"unstyled\" ui-sortable ng-model=\"lists\">\n");
            out.write("            <hr>\n");
            out.write("            <p ng-repeat=\"list in lists\"><a ng-click=\"loadList(list);\"\n");
            out.write("                                              class=\"btn btn-block btn-primary\">{{list.name}}</a></p>\n");
            out.write("\n");
            out.write("        </div>\n");
            out.write("\n");
            out.write("        `\n");
            out.write("\n");
            out.write("\n");
            out.write("    </div>\n");
            out.write("    <div class=\"col-lg-10\">\n");
            out.write("        <div ng-show=\"lists.length>0\" class=\"list\">\n");
            out.write("            <h4 class=\"title\" editable=\"updateList\" contentEditable=\"true\" ng-model=\"currentList.name\"></h4>\n");
            out.write("\n");
            out.write("            <div class=\"wrapper\">\n");
            out.write("                <form ng-submit=\"addItem()\">\n");
            out.write("                    <input type=\"text\" ng-model=\"newItem\" autofocus placeholder=\"Ajouter Ã  la liste...\"\n");
            out.write("                           class=\"form-control\"/>\n");
            out.write("                </form>\n");
            out.write("                <hr>\n");
            out.write("                <p class=\"input-group\" ng-repeat=\"item in currentList.items\">\n");
            out.write("\n");
            out.write("                        <input type=\"text\" ng-model=\"item.name\" class=\"form-control\">\n");
            out.write("                        <span class=\"input-group-btn\">\n");
            out.write("                            <button class=\"btn btn-danger\" ng-click=\"removeItem(item)\" aria-label=\"Remove\">X</button>\n");
            out.write("                        </span>\n");
            out.write("\n");
            out.write("                </p>\n");
            out.write("\n");
            out.write("\n");
            out.write("\n");
            out.write("            </div>\n");
            out.write("            <section class=\"actions\">\n");
            out.write("                <button class=\"btn btn-danger\" ng-click=\"deleteList();\" aria-label=\"Remove\">Remove all</button>\n");
            out.write("            </section>\n");
            out.write("        </div>\n");
            out.write("    </div>\n");
            out.write("\n");
            out.write("\n");
            out.write("    <div class=\"footer\">\n");
            out.write("\n");
            out.write("    </div>\n");
            out.write("</div>\n");
            out.write("\n");
            out.write("\n");
            out.write("<!--\n");
            out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js\"></script>\n");
            out.write(" -->\n");
            out.write("<script src=\"lib/jquery-1.9.0.min.js\"></script>\n");
            out.write("\n");
            out.write("<!-- In production use:\n");
            out.write("<script src=\"//ajax.googleapis.com/ajax/libs/angularjs/1.0.4/angular.min.js\"></script>\n");
            out.write("-->\n");
            out.write("<script src=\"lib/angular/angular.min.js\"></script>\n");
            out.write("<script src=\"lib/angular/angular-resource.min.js\"></script>\n");
            out.write("\n");
            out.write("<script src=\"js/app.js\"></script>\n");
            out.write("<script src=\"js/services.js\"></script>\n");
            out.write("<script src=\"js/controllers.js\"></script>\n");
            out.write("<script src=\"js/filters.js\"></script>\n");
            out.write("<script src=\"js/directives.js\"></script>\n");
            out.write("</body>\n");
            out.write("</html>");
        } catch (Throwable t) {
            if (!(t instanceof SkipPageException)) {
                out = _jspx_out;
                if (out != null && out.getBufferSize() != 0)
                    try {
                        out.clearBuffer();
                    } catch (java.io.IOException e) {
                    }
                if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
            }
        } finally {
            _jspxFactory.releasePageContext(_jspx_page_context);
        }
    }
}
