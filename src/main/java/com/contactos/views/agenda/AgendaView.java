package com.contactos.views.agenda;

import com.contactos.models.Contacto;
import com.contactos.services.ContactoService;
import com.contactos.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.util.List;

@PageTitle("Agenda")
@Route(value = "agenda", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class AgendaView extends Composite<VerticalLayout> {
    List<Contacto> contactos;
    ContactoService contactoService;
    public AgendaView(ContactoService contactoService) {
    this.contactoService=contactoService;
        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        buttonPrimary.setText("Nuevo Contacto");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary.addClickListener(e -> {
            buttonPrimary.getUI().ifPresent(ui ->
                    ui.navigate("contacto"));
        });

        Grid<Contacto> grid = new Grid<>(Contacto.class, false);
        grid.addColumn(Contacto::getNombre).setHeader("Nombre").setAutoWidth(true);
        grid.addColumn(Contacto::getCodigo).setHeader("Codigo").setAutoWidth(true);
        grid.addColumn(Contacto::getCelular).setHeader("Celular").setAutoWidth(true);
        grid.addColumn(Contacto::getEmail).setHeader("Email").setAutoWidth(true);
        grid.addColumn(
                new ComponentRenderer<>(contacto-> {
                    Button botonBorrar = new Button();
                    botonBorrar.addThemeVariants(ButtonVariant.LUMO_ERROR);
                    botonBorrar.addClickListener(e -> {
                        contactoService.borrarContacto(contacto.getEmail());
                        contactos.clear();
                        contactos.addAll(contactoService.listaContactos());
                        grid.getDataProvider().refreshAll();
                    });
                    botonBorrar.setIcon(new Icon(VaadinIcon.TRASH));
                    HorizontalLayout buttons = new HorizontalLayout(botonBorrar);
                    return buttons;
                })).setHeader("Manage").setAutoWidth(true);

                    contactos = contactoService.listaContactos();
                    grid.setItems(contactos);
                    grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
                    getContent().add(buttonPrimary,grid);

                }
}
