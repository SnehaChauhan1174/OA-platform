# OAForge — Online Assessment Practice Platform

> Simulate real company OAs. Build your own. Practice like it's the real thing.

---

## The Problem

Most students prepare for placements by solving random LeetCode problems. But real OAs have structure — specific sections, topic distributions, time pressure, and question types that vary by company. Walking into a 90-minute timed assessment with no idea what format to expect is a completely avoidable problem.

OAForge bridges that gap.

---

## What OAForge Does

### Company OA Mode
Select a company and get a generated OA that mirrors their real pattern. Topic weights, section structure, difficulty distribution, and time limits are all based on historical OA data. Amazon's OA feels different from TCS's — and it should.

### Custom OA Mode
Build your own OA from scratch. Pick your sections (Coding, MCQ, SQL, Aptitude), choose topics, set your time limit, and the platform generates a fresh assessment. Want to practice only SQL joins under time pressure? Do exactly that.

Adaptive difficulty adjusts question difficulty based on your historical solve rate — if you're solving 70%+ of medium problems, it pushes you to hard. Struggling below 40%? It finds your level first.

Both modes run in a fully controlled environment — server-enforced timers, section-wise navigation, real code execution, and a detailed score report on completion.

---

## Core Features

- Company-wise OA simulation using weighted topic sampling
- Custom OA builder — configure sections, topics, time, difficulty
- Adaptive difficulty engine based on student solve rate history
- Real code execution via Judge0 (Accepted, Wrong Answer, TLE, Runtime Error)
- MCQ auto-evaluation with instant verdict
- Section-wise score report with per-question breakdown
- Admin panel for managing company profiles and question bank
- JWT-based authentication with role separation (Student / Admin)

---

## System Design

### Architecture
Modular monolith — each domain (auth, OA generation, code execution, scoring) is independently structured. Stateless Spring Boot service designed for horizontal scaling.

### OA Generation Engine
Company OA uses weighted random sampling — each company profile stores topic-to-weight mappings. The engine samples questions proportional to these weights, deduplicates against the user's past sessions, and locks the question set into a session with a server-side expiry timestamp.

### Timer Enforcement
Two-layer timer system. Frontend shows a countdown for UX. Backend stores `expires_at` in the session row and rejects any submission received after that timestamp. Client-side timer is cosmetic only — the server is the source of truth.

### Adaptive Difficulty
Calculates solve rate per topic per difficulty from submission history:
- Solve rate > 70% on Medium → push to Hard
- Solve rate 40–70% on Medium → stay at Medium with Hard sprinkled in
- Solve rate < 40% → mix Easy and Medium to find level

New users complete a one-time self-assessment. System switches to history-based adaptation after 5 OA attempts.

### Idempotent Submissions
Before inserting a submission row, the system checks if one already exists for that `session_id + question_id`. Duplicate submissions (network retry, double click) are safely handled — same result returned, no double processing.

### Data Model
users ──< oa_sessions >── companies
questions ──< submissions >── oa_sessions
questions ──< company_question_tags >── companies
questions ──< mcq_options
users ──< custom_oa_configs ──< oa_sessions

