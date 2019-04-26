/*
 * Copyright (C) 2016 Eduardo Noel Núñez<enoel@cubalub.cupet.cu>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package cu.cupet.cubalub.utiles;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Eduardo Noel Núñez <enoel@cubalub.cupet.cu>
 */
public class TGraficos {

    ImageView cerrar = new ImageView("/img/process-stop.png");
    ImageView nuevo = new ImageView("/img/document-new.png");
    ImageView add = new ImageView("/img/add.png");
    ImageView del = new ImageView("/img/remove.png");
    Image icon = new Image("/img/icon.ico");

    public ImageView getCerrar() {
        return cerrar;
    }

    public Image getIcon() {
        return icon;
    }

    public ImageView getNuevo() {
        return nuevo;
    }

    public ImageView getAdd() {
        return add;
    }

    public ImageView getDel() {
        return del;
    }

    private TGraficos() {
    }

    public static TGraficos Singleton() {
        return GraficosHolder.INSTANCE;
    }

    private static class GraficosHolder {

        private static final TGraficos INSTANCE = new TGraficos();
    }
}
