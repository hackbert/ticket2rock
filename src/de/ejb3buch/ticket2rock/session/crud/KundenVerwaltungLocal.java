/**
 *  Ticket2Rock ist die Beispielanwendung des Buchs "EJB 3 professionell" (dpunkt).
 *  Es implementiert eine einfache Webanwendung zur Onlinebuchung von Tickets f�r
 *  Rockkonzerte auf Basis von EJB 3.0 und JavaServer Faces.
 *
 *  Copyright (C) 2006
 *  Jo Ehm, Dierk Harbeck, Stefan M. Heldt, Oliver Ihns, Jochen J�rg, Holger Koschek,
 *  Carsten Sahling, Roman Schloemmer
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package de.ejb3buch.ticket2rock.session.crud;

import javax.ejb.Local;

import de.ejb3buch.ticket2rock.entity.Kunde;

@Local
public interface KundenVerwaltungLocal {

    /**
     * Legt eine Kunden-Entit�t in der Persistenzschicht an
     * @param musiker Kunden-POJO mit den Attributen des anzulegenden
     * Kunden.
     */
	public void createKunde(Kunde kunde);
	
	/**
	 * Selektiert eine Kunden-Entit�t mit einer gegebenen Email Adresse
	 * @param email email Adresse
	 * @return Kunden Objekt, das die bestimmte email Adresse besitzt.
	 * Existiert kein Kunde mit dieser email Adresse, ist der R�ckgabewert null
	 */
	public Kunde getKundeByEmail(String email);

}
