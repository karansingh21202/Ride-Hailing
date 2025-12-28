# 📁 Project Structure Overview

> **Note:** This shows the COMPLETE structure with all files that need to be created.  
> Files marked with member numbers show who is responsible.  
> This is approximate guidance - not 100% accurate but will help you understand the work.

---

```
Ride-Hailing/
│
├── backend/
│   ├── pom.xml                                       ✅ DONE
│   │
│   └── src/
│       ├── main/
│       │   ├── java/
│       │   │   └── com/
│       │   │       └── ridehailing/
│       │   │           │
│       │   │           ├── model/                    # 👤 Member 1
│       │   │           │   ├── User.java
│       │   │           │   ├── Vehicle.java
│       │   │           │   ├── Ride.java
│       │   │           │   ├── Payment.java
│       │   │           │   └── Rating.java
│       │   │           │
│       │   │           ├── repository/               # 👤 Member 1
│       │   │           │   ├── UserRepository.java
│       │   │           │   ├── VehicleRepository.java
│       │   │           │   ├── RideRepository.java
│       │   │           │   ├── PaymentRepository.java
│       │   │           │   └── RatingRepository.java
│       │   │           │
│       │   │           ├── service/                  # 👤 Member 3 & 4
│       │   │           │   ├── UserService.java
│       │   │           │   ├── VehicleService.java
│       │   │           │   ├── RideService.java      # Member 3
│       │   │           │   ├── PaymentService.java   # Member 4
│       │   │           │   └── RatingService.java    # Member 4
│       │   │           │
│       │   │           ├── servlet/
│       │   │           │   ├── auth/                 # 👤 Member 2
│       │   │           │   │   ├── RegisterServlet.java
│       │   │           │   │   └── LoginServlet.java
│       │   │           │   │
│       │   │           │   ├── ride/                 # 👤 Member 3
│       │   │           │   │   ├── RideRequestServlet.java
│       │   │           │   │   ├── RideAcceptServlet.java
│       │   │           │   │   ├── RideStartServlet.java
│       │   │           │   │   ├── RideCompleteServlet.java
│       │   │           │   │   ├── RideCancelServlet.java
│       │   │           │   │   └── RideListServlet.java
│       │   │           │   │
│       │   │           │   ├── payment/              # 👤 Member 4
│       │   │           │   │   └── PaymentServlet.java
│       │   │           │   │
│       │   │           │   ├── rating/               # 👤 Member 4
│       │   │           │   │   └── RatingServlet.java
│       │   │           │   │
│       │   │           │   └── vehicle/              # 👤 Member 1
│       │   │           │       └── VehicleServlet.java
│       │   │           │
│       │   │           ├── filter/                   # 👤 Member 2
│       │   │           │   ├── AuthFilter.java
│       │   │           │   └── CORSFilter.java
│       │   │           │
│       │   │           ├── dto/                      # Shared (All Members)
│       │   │           │   ├── request/
│       │   │           │   │   ├── RegisterRequest.java
│       │   │           │   │   ├── LoginRequest.java
│       │   │           │   │   ├── RideRequest.java
│       │   │           │   │   ├── PaymentRequest.java
│       │   │           │   │   └── RatingRequest.java
│       │   │           │   │
│       │   │           │   └── response/
│       │   │           │       ├── ApiResponse.java
│       │   │           │       ├── AuthResponse.java
│       │   │           │       ├── RideResponse.java
│       │   │           │       └── ErrorResponse.java
│       │   │           │
│       │   │           ├── util/                     # 👤 Member 2
│       │   │           │   ├── PasswordUtil.java
│       │   │           │   ├── JwtUtil.java
│       │   │           │   └── JsonUtil.java
│       │   │           │
│       │   │           └── config/                   # 👤 Member 1
│       │   │               └── HibernateUtil.java
│       │   │
│       │   ├── resources/
│       │   │   ├── hibernate.cfg.xml                 ✅ DONE (⚠️ Password change karo - neeche dekho)
│       │   │   └── META-INF/
│       │   │       └── persistence.xml               ✅ DONE
│       │   │
│       │   └── webapp/
│       │       └── WEB-INF/
│       │           └── web.xml                       ✅ DONE
│       │
│       └── test/
│           └── java/
│               └── com/
│                   └── ridehailing/
│                       └── (test classes - optional)
│
├── frontend/                                         # 👤 Member 5
│   ├── index.html
│   │
│   ├── pages/
│   │   ├── login.html
│   │   ├── register.html
│   │   ├── rider-dashboard.html
│   │   └── driver-dashboard.html
│   │
│   ├── css/
│   │   └── styles.css
│   │
│   └── js/
│       ├── api.js
│       ├── auth.js
│       ├── rider.js
│       └── driver.js
│
├── db/                                               # 👤 Member 1
│   ├── schema.sql
│   └── seed.sql
│
├── docs/                                             # 👤 Member 5
│   └── API.md
│
├── README.md                                         ✅ DONE
├── MEMBER_GUIDE.md                                   ✅ DONE
├── CONTRIBUTING.md                                   ✅ DONE
├── PROJECT_STRUCTURE.md                              ✅ THIS FILE
└── .gitignore                                        ✅ DONE
```

---

## 📊 Member-wise File Count

| Member | Files to Create | Folders |
|--------|-----------------|---------|
| **Member 1** | 13 files | model, repository, config, servlet/vehicle, db |
| **Member 2** | 7 files | servlet/auth, filter, util |
| **Member 3** | 8 files | servlet/ride, service (Ride) |
| **Member 4** | 5 files | servlet/payment, servlet/rating, service (Payment, Rating) |
| **Member 5** | 9 files | frontend (all), docs |
| **Shared** | 9 files | dto/request, dto/response |

---

## ✅ Already Done (by Maintainer)

- `pom.xml` - Maven dependencies
- `hibernate.cfg.xml` - DB config (update password)
- `persistence.xml` - JPA config
- `web.xml` - Servlet mappings
- `README.md` - Project overview
- `MEMBER_GUIDE.md` - Team guide
- `CONTRIBUTING.md` - Git workflow
- All folder structure with `.gitkeep` placeholders

---

> 💡 **Tip:** Delete the `.gitkeep` file after creating your actual `.java` or `.html` file in that folder!

---

## 🖥️ Apne System mein Project Kaise Chalao? (Local Setup)

> **🙏 Ghabrao mat!** Ye steps follow karo, sab kaam kar jayega.

### Step 1: Database Setup (MySQL)

**Option A: Sirf Database Banao (Abhi ke liye)**
```sql
-- MySQL mein login karo
mysql -u root -p

-- Database banao
CREATE DATABASE ride_hailing_db;

-- Check karo bana ki nahi
SHOW DATABASES;

-- Exit karo
exit;
```

---

**Option B: Member 1 (Abhishek/Tiwari) ne SQL File Share Ki? unki jimmedari thi i guess**

Agar kisi ne WhatsApp pe `schema.sql` ya `database.sql` file share ki hai, toh aise import karo:koi problem ho to gpt se pucho

**Step 1:** File download karo aur `db/` folder mein daalo

**Step 2:** Command Prompt/PowerShell mein ye run karo:
```bash
# Pehle project folder mein jao
cd d:\Ride-Hailing

# SQL file import karo
mysql -u root -p ride_hailing_db < db/schema.sql
```

**Ya MySQL mein directly:**
```sql
-- MySQL mein login karo
mysql -u root -p

-- Database select karo
USE ride_hailing_db;

-- SQL file run karo (full path do)
SOURCE d:/Ride-Hailing/db/schema.sql;

-- Tables check karo
SHOW TABLES;
```

**Expected Tables:**
```
+---------------------------+
| Tables_in_ride_hailing_db |
+---------------------------+
| user                      |
| vehicle                   |
| ride                      |
| payment                   |
| rating                    |
+---------------------------+
```

> 💡 **Tip:** Agar `seed.sql` bhi mila hai toh woh bhi run karo - usme sample data hoga!

### Step 2: Password Update Karo ⚠️ (IMPORTANT!)

2 files mein password update karna hai:

**File 1:** `backend/src/main/resources/hibernate.cfg.xml`
```xml
<!-- Line 12 mein ye dhundho: -->
<property name="hibernate.connection.password">your_password_here</property>

<!-- Isko change karo apne MySQL password se: -->
<property name="hibernate.connection.password">TumharaActualPassword</property>
```

**File 2:** `backend/src/main/resources/META-INF/persistence.xml`
```xml
<!-- Line 24 mein ye dhundho: -->
<property name="javax.persistence.jdbc.password" value="your_password_here"/>

<!-- Isko change karo: -->
<property name="javax.persistence.jdbc.password" value="TumharaActualPassword"/>
```

> ⚠️ **IMPORTANT:** Ye password changes COMMIT MAT KARO! Sirf local mein rakho.

### Step 3: Build Karo

```bash
cd backend
mvn clean install
```

**Agar error aaye:**
- `BUILD SUCCESS` = ✅ Sab theek hai
- `BUILD FAILURE` = ❌ Error message padho, mostly dependency issue hoti hai

### Step 4: Tomcat mein Deploy Karo

1. `backend/target/ride-hailing.war` file copy karo
2. Tomcat ke `webapps` folder mein paste karo
3. Tomcat start karo
4. Browser mein jaao: `http://localhost:8080/ride-hailing`

---

## 🚫 Common Problems - Ghabrao Mat!

### ❌ "Port 8080 already in use"
```
Solution: 
- Task Manager → Java process kill karo
- Ya Tomcat ko doosre port pe chalao
```

### ❌ "Access denied for user 'root'"
```
Solution:
- hibernate.cfg.xml mein password check karo
- MySQL service running hai ki nahi check karo
```

### ❌ "Cannot find symbol" error
```
Solution:
cd backend
mvn clean install -U
```

### ❌ "Table doesn't exist"
```
Solution:
- schema.sql run karo pehle
- Ya hibernate.hbm2ddl.auto=update karo (already set hai)
```

---

## 🔐 Apna Password Commit Mat Karo!

Ye files mein password hai - ye KABHI commit mat karo:
- `hibernate.cfg.xml`
- `persistence.xml`

**Safe way:**
1. `.gitignore` mein add karo (future improvement)
2. Ya environment variables use karo (advanced)
3. Ya sirf local changes rakho, commit mat karo

---

## 🤖 Kuch samajh na aaye?

1. **AI se poocho:** Error copy karo → ChatGPT/Claude mein paste karo
2. **Google karo:** Error message + "java servlet" search karo
3. **Team se poocho:** PR comment mein likho
4. **Maintainer se poocho:** @karansingh21202

> 💪 **Yaad rakho:** Har developer ko errors aate hain. Problem solve karna = Learning!

