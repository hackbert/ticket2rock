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

package de.ejb3buch.ticket2rock.session.demo;

import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

import de.ejb3buch.ticket2rock.session.demo.klasseninterzeptor.dd.AbfangjaegerBean;

// Eine Interzeptor-Klasse, die im Deployment-Deskriptor ejb-jar.xml
// als solche definiert ist.

public class Abfangjaeger {

	static Logger logger = Logger.getLogger(AbfangjaegerBean.class);

	public Object onMethodCall(InvocationContext ctx) throws Exception {
		logger.info(ctx.getMethod());
		return ctx.proceed();
	}
}
