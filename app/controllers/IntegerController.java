package controllers;

import java.lang.reflect.Field;

import javax.inject.Inject;

import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.data.format.Formatters;
import play.mvc.Controller;
import play.mvc.Result;
import scala.Option;

public class IntegerController extends Controller {
    private static final Field INTEGER_FIELD;

    static {
        try {
            INTEGER_FIELD = IntegerDto.class.getDeclaredField("integer");
        } catch (Exception e) {
            throw new IllegalStateException("Failed to field controllers.IntegerListDto#integer");
        }
    }

    private final Formatters formatters;

    private final Form<IntegerDto> form;
    private final DynamicForm dynamicForm;

    @Inject
    public IntegerController(Formatters formatters, FormFactory formFactory) {
        this.formatters = formatters;

        this.form = formFactory.form(IntegerDto.class);
        this.dynamicForm = formFactory.form();
    }

    public Result index() {
        return ok(views.html.index.render(form.fill(new IntegerDto(1)), Option.apply(flash("integer"))));
    }

    public Result save() {
        Integer integer = formatters.parse(INTEGER_FIELD, dynamicForm.bindFromRequest().get("integer"), Integer.class);
        flash("integer", integer.toString());
        return redirect(routes.IntegerController.index());
    }
}
