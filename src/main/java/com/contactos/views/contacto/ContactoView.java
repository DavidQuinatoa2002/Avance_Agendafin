package com.contactos.views.contacto;

import com.contactos.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Contacto")
@Route(value = "contacto", layout = MainLayout.class)
@Uses(Icon.class)
public class ContactoView extends Composite<VerticalLayout> {

    private TextField nombreTextField;
    private TextField celularTextField;
    private EmailField emailField;
    private TextField idTextField;

    public ContactoView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        H2 h2 = new H2();
        nombreTextField = new TextField("Nombre");
        celularTextField = new TextField("Celular");
        emailField = new EmailField("Email");
        idTextField = new TextField("ID");
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        HorizontalLayout layoutRow4 = new HorizontalLayout();
        Hr hr = new Hr();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        Button buttonPrimary = new Button("Guardar");
        Button buttonSecondary = new Button("Cancelar");
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        h2.setText("Ingresar Contacto");
        h2.setWidth("max-content");
        layoutRow2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        nombreTextField.setLabel("Nombre");
        nombreTextField.setWidth("min-content");
        celularTextField.setLabel("Celular");
        celularTextField.setWidth("min-content");
        layoutRow3.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.getStyle().set("flex-grow", "1");
        emailField.setLabel("Email");
        emailField.setWidth("min-content");
        idTextField.setLabel("ID");
        idTextField.setWidth("min-content");
        layoutRow4.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow4);
        layoutRow4.addClassName(Gap.MEDIUM);
        layoutRow4.setWidth("100%");
        layoutRow4.getStyle().set("flex-grow", "1");
        buttonPrimary.addClickListener(event -> guardarContacto());
        buttonSecondary.addClickListener(event -> cancelarEdicion());
        buttonPrimary.setText("Guardar");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonSecondary.setText("Cancelar");
        buttonSecondary.setWidth("min-content");
        layoutColumn2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        getContent().add(layoutRow);
        layoutRow.add(h2);
        getContent().add(layoutRow2);
        layoutRow2.add(nombreTextField);
        layoutRow2.add(celularTextField);
        getContent().add(layoutRow3);
        layoutRow3.add(emailField);
        layoutRow3.add(idTextField);
        getContent().add(layoutRow4);
        layoutRow4.add(buttonPrimary);
        layoutRow4.add(buttonSecondary);
        getContent().add(hr);
        getContent().add(layoutColumn2);

    }
    private void guardarContacto() {
        String nombre = nombreTextField.getValue();
        String celular = celularTextField.getValue();
        String email = emailField.getValue();
    }
    private void cancelarEdicion(){
        nombreTextField.clear();
        celularTextField.clear();
        emailField.clear();
        idTextField.clear();
    }
}