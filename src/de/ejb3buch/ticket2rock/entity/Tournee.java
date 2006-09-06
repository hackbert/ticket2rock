/**
 *  Ticket2Rock ist die Beispielanwendung des Buchs "EJB 3 professionell" (dpunkt).
 *  Es implementiert eine einfache Webanwendung zur Onlinebuchung von Tickets f�r
 *  Rockkonzerte auf Basis von EJB 3.0 und JavaServer Faces.
 *
 *  Copyright (C) 2006
 *  Dierk Harbeck, Stefan M. Heldt, Oliver Ihns, Jochen J�rg und Holger Koschek
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

package de.ejb3buch.ticket2rock.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Im Rahmen einer Tournee werden ein oder mehrere Konzerte von einem
 * Interpreten durchgef�hrt. Eine Tournee hat einen Namen.
 */

@Entity
public class Tournee {
	private int id;

	private String name;

	private Interpret interpret;

	private List<Konzert> konzerte;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	public Interpret getInterpret() {
		return interpret;
	}

	public void setInterpret(Interpret interpret) {
		this.interpret = interpret;
	}

	// Hier muss der Default Fetch Type (LAZY) �berschrieben werden,
	// sonst beschwert sich JBoss ("org.hibernate.LazyInitializationException:
	// failed to lazily initialize a collection of role:
	// de.ejb3buch.ticket2rock.entity.Tournee.konzerte,
	// no session or session was closed")
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tournee")
	public List<Konzert> getKonzerte() {
		return konzerte;
	}

	public void setKonzerte(List<Konzert> konzerte) {
		this.konzerte = konzerte;
	}
}