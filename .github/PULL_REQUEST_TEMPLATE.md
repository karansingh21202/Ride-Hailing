# Pull Request

## ⚠️ PEHLE CHECK KARO!

### Base Branch `dev` Hai?

PR banate waqt **base branch** check karo:

```
base: dev  ←  compare: your-feature-branch
```

**Agar `main` select ho gaya hai, toh fix karo:**

1. PR page pe dekho: `base: main` likha hai
2. "Edit" pe click karo (title ke paas)
3. Base branch dropdown se `dev` select karo
4. "Update" click karo

> ❌ `main` pe PR → Reject hoga!  
> ✅ `dev` pe PR → Review hoga!

---

## 📋 Checklist (Mark karo)

- [ ] Base branch `dev` hai ✅
- [ ] Apne fork se PR bana raha hoon (main repo se nahi)
- [ ] Upstream se latest code liya hai (`git pull upstream dev`)
- [ ] Folder structure change NAHI ki
- [ ] Code test kar liya hai (`mvn clean compile`)
- [ ] Meaningful commit messages likhe hain

---

## 📝 Changes Description

### Kya kiya?
<!-- 
Short mein batao kya changes kiye:
- Feature add ki
- Bug fix kiya
- Documentation update ki
-->

### Kaunse files change kiye?
<!-- 
List karo main files:
- model/User.java
- servlet/auth/LoginServlet.java
-->

### Testing
<!-- 
Kaise test kiya:
- Locally run kiya
- Postman se API test kiya
- Database check kiya
-->

---

## 🔗 Related

- Fixes # (issue number, agar hai toh)
- Related to # (PR number, agar hai toh)

---

## 📸 Screenshots (Optional)

<!-- Agar UI change hai toh screenshot daalo -->
