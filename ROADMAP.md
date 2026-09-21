# Spring PetClinic Learning Roadmap

This roadmap locks the build order for the from-scratch PetClinic learning project.

The project follows the current canonical Spring PetClinic shape as a reference: Spring Boot, Maven, Thymeleaf, MVC, JPA, validation, H2, MySQL/PostgreSQL profiles, testing, and production-oriented tooling. We are rebuilding the application ourselves instead of copying the canonical repository.

Reference baseline:
- https://github.com/spring-projects/spring-petclinic
- https://docs.spring.io/spring-boot/system-requirements.html

## Current Position

- Track: 650 core batches
- Completed: 001-008
- Next: 009
- Current codebase: one Java application class plus the learning README
- Current problem identified: batches 001-008 were too granular for the intended project pace

## Roadmap Rules

These rules apply to every future batch.

1. Inspect the real repository before writing the next batch.
2. A normal batch must deliver one coherent engineering milestone, not one trivial syntax line.
3. A batch may create or modify several related files when they belong to the same milestone.
4. Prefer meaningful vertical slices over artificial micro-steps.
5. Do not repeat environment checks already proven unless a new tool or runtime is introduced.
6. Run only the verification needed for the change: normally one focused test/build/run sequence at the end.
7. Add tests when behavior deserves a test, not merely to consume a batch.
8. Keep prompts compact and zero-context: include only the current files/code needed to execute that batch.
9. Repository content is English only.
10. Batch comments are one concise comment per meaningful code section. No per-line comments and no Part numbering.
11. Generated build output is never committed.
12. If a prerequisite is genuinely missing, insert a `⭐ Prerequisite` batch instead of forcing the planned batch.
13. If the build order needs a meaningful change, update this roadmap before changing course.
14. Every pushed batch ends with a verification checklist.
15. User approval remains the gate before repository changes are pushed.

## Version Policy

Do not hard-code future framework versions in this roadmap.

When a batch first introduces or upgrades Spring Boot, Java, Maven, database drivers, or other major dependencies, verify the currently supported version from official documentation and pin it in the project at that time.

The current Spring Boot 4.1 line requires Java 17 or newer and Maven 3.6.3 or newer.

---

# Phase Map

| Batches | Phase | Primary outcome |
|---|---|---|
| 001-008 | Foundations | Java project, package, main method, compile/run basics |
| 009-020 | Spring Boot Foundation | Real Maven/Spring Boot web application with a working home page |
| 021-050 | MVC and Thymeleaf Shell | Reusable web layout, navigation, forms, static assets, system pages |
| 051-100 | Domain and JPA Foundation | Reusable entity model, JPA mapping, H2 persistence, repository conventions |
| 101-160 | Owner Feature | Complete owner search/create/read/update workflow |
| 161-220 | Pet and PetType Feature | Complete pet lifecycle and owner-pet relationships |
| 221-270 | Visit Feature | Visit creation, validation, persistence, and owner history integration |
| 271-320 | Vet and Specialty Feature | Veterinarian/specialty domain, persistence, UI, and API-oriented views |
| 321-370 | Persistence and Data Engineering | Schema/data initialization, queries, pagination, profiles, repository tuning |
| 371-420 | Validation, Errors, Formatting, i18n | Strong user input handling and consistent application UX |
| 421-470 | Testing Strategy | Unit, MVC, repository, integration, regression, and concurrency tests |
| 471-510 | MySQL/PostgreSQL and Containers | Persistent DB profiles, Docker Compose, Testcontainers, portability |
| 511-550 | Transactions, Concurrency, Cache | Transaction boundaries, locking, race conditions, caching |
| 551-590 | Observability, Performance, Resilience | Actuator, logs, diagnostics, performance and failure handling |
| 591-620 | CI, Quality, Release Engineering | GitHub Actions, quality gates, coverage, reproducible builds |
| 621-640 | Deployment and Production Hardening | Container images, configuration, runtime safety, deployment checks |
| 641-650 | Final Architecture and Interview Capstone | Full-system review, refactoring, production walkthrough, interview defense |

---

# Phase 0 — Foundations

## Batches 001-008 — COMPLETE

Completed outcomes:
- Repository initialized
- Learning README created
- Java source structure created
- Package `org.springframework.samples.petclinic` created
- `PetClinicApplication` created
- `main()` introduced
- Manual `javac` compile/run lifecycle practiced
- First executable console statement added

Exit gate: complete.

---

# Phase 1 — Spring Boot Foundation

## Batches 009-020

Goal: stop treating the repository as a plain Java demo and turn it into a real Spring Boot web project.

### Locked near-term sequence

**009 — Maven + Spring Boot bootstrap**
- Create `pom.xml`
- Add Maven wrapper for Windows-friendly reproducible builds
- Add `.gitignore`
- Convert `PetClinicApplication` into the Spring Boot entry point
- Build and start the app

**010 — First real HTTP page**
- Add Spring MVC + Thymeleaf support
- Create `WelcomeController`
- Create `welcome.html`
- Verify `GET /`

**011 — Shared web layout**
- Introduce Thymeleaf fragments/layout
- Add common header/navigation/footer
- Make the welcome page use the shared structure

**012 — Static resources**
- Add project CSS and static resource structure
- Style the shared shell enough to make future screens usable

**013 — System package**
- Establish the `system` package
- Add focused application/system web concerns
- Add a basic error page path

**014 — Persistence dependencies**
- Add JPA, validation, and H2
- Create baseline `application.properties`
- Start successfully with the in-memory database

**015 — Base domain classes**
- Create `BaseEntity`
- Create `NamedEntity`
- Create `Person`
- Add useful JPA/validation mapping

**016 — Package architecture**
- Establish `model`, `owner`, `vet`, and `system` boundaries
- Move only code that belongs in the new structure
- Keep package responsibilities explicit

**017 — Test harness**
- Establish the Spring Boot test structure
- Add one context/smoke test and one MVC route test
- Avoid duplicating trivial tests

**018 — Messages and i18n baseline**
- Add message bundle structure
- Wire basic localized labels/messages into the existing UI

**019 — Development configuration**
- Add a development-friendly profile/configuration
- Clarify runtime configuration versus committed defaults

**020 — Foundation checkpoint**
- Full clean build
- App startup
- Home page smoke check
- Remove obsolete placeholders
- Confirm project structure before domain feature work

### Phase 1 exit gate

The repository must have:
- Reproducible Maven build
- Spring Boot startup
- Working browser home page
- Thymeleaf shell
- H2/JPA/validation available
- Base domain classes
- Initial automated test harness
- Clean package structure

---

# Phase 2 — MVC and Thymeleaf Shell

## Batches 021-050

Goal: build the reusable web foundation needed by every PetClinic feature.

Planned work:
- Controller conventions
- Request mappings and model attributes
- Thymeleaf expressions
- Reusable form fragments
- Text/select input fragments
- Navigation states
- Form GET/POST lifecycle
- Redirect-after-POST
- Flash/status messaging
- Static resource conventions
- Error page rendering
- 404/validation UX
- Date formatting
- Shared table/list patterns
- Pagination UI primitives
- Basic responsive layout
- Internationalized labels
- System welcome/error controllers
- Web configuration where necessary

Exit gate:
- New feature screens can be built without inventing a new UI structure each time.
- Shared fragments support forms, tables, validation messages, and navigation.

---

# Phase 3 — Domain and JPA Foundation

## Batches 051-100

Goal: establish the entity and persistence patterns that all core features will reuse.

Planned work:
- Entity identity and lifecycle
- `BaseEntity`
- `NamedEntity`
- `Person`
- Jakarta Persistence annotations
- Bean Validation
- Equality/identity considerations
- Repository interfaces
- Spring Data JPA conventions
- Query derivation
- Explicit JPQL where useful
- Entity relationships
- Collection ownership
- Cascade/orphan behavior
- Date fields
- H2 schema behavior
- Seed data conventions
- Transaction basics
- Repository-focused tests
- Entity validation tests
- Mapping failure exercises
- SQL visibility/logging during development

Exit gate:
- The project has stable persistence conventions.
- Domain classes can be added without redesigning identity, validation, or repository patterns.

---

# Phase 4 — Owner Feature

## Batches 101-160

Goal: deliver the first complete business vertical slice.

Planned work:
- `Owner` entity
- Owner fields and validation
- Owner repository
- Search by last name
- Owner list
- Owner detail
- Create owner
- Update owner
- Form binding
- Validation error display
- Not-found handling
- Pagination for search results
- Redirect flows
- Owner-specific templates
- Repository tests
- Controller tests
- Integration tests
- Refactoring duplicated MVC code

Exit gate:
- A user can search, create, inspect, and update owners through the browser.
- Owner behavior is covered by focused automated tests.

---

# Phase 5 — Pet and PetType Feature

## Batches 161-220

Goal: build pets as real child entities of owners.

Planned work:
- `PetType`
- `Pet`
- Owner-to-pet relationship
- Pet repository/data access
- Pet type lookup
- Pet formatter/conversion
- Add pet
- Edit pet
- Pet validation
- Birth date handling
- Duplicate-name business rules where appropriate
- Owner detail integration
- Pet forms/templates
- Controller tests
- Validator tests
- Persistence tests

Exit gate:
- Owners can have multiple pets.
- Pets can be created and updated with valid types and dates.
- Owner detail shows the complete pet collection.

---

# Phase 6 — Visit Feature

## Batches 221-270

Goal: add clinical visit history.

Planned work:
- `Visit` entity
- Pet-to-visit relationship
- Visit date/description validation
- Create visit
- Display visit history
- Owner detail integration
- Persistence behavior
- Controller flow
- Validation UX
- Repository/query behavior as needed
- MVC and integration tests

Exit gate:
- A visit can be added to a pet and appears in that pet's history.

---

# Phase 7 — Vet and Specialty Feature

## Batches 271-320

Goal: complete the second major aggregate area.

Planned work:
- `Specialty`
- `Vet`
- Vet-specialty relationship
- Vet repository
- Vet list page
- Specialty display
- `Vets` wrapper/representation where useful
- JSON/XML/API-oriented representation exercises
- Caching candidate identification
- Controller and repository tests

Exit gate:
- Veterinarians and specialties are persisted and viewable through the application.

---

# Phase 8 — Persistence and Data Engineering

## Batches 321-370

Goal: make persistence intentional rather than incidental.

Planned work:
- H2 initialization strategy
- Schema/data scripts
- Realistic seed data
- Repository query review
- Pagination
- Sorting
- N+1 detection
- Fetch strategy
- Entity graph/query tuning where justified
- SQL logging
- Index awareness
- Data reset strategy for tests
- Profile-specific configuration structure
- Database constraint alignment with Bean Validation

Exit gate:
- Core features use deliberate queries and reproducible data.
- Common JPA performance mistakes are identified and fixed.

---

# Phase 9 — Validation, Errors, Formatting, i18n

## Batches 371-420

Goal: harden user-facing behavior.

Planned work:
- Bean Validation review
- Custom validation
- Cross-field rules
- Pet-specific validator
- Type formatting/conversion
- Date parsing
- Binding errors
- Global exception handling where appropriate
- 404/not-found behavior
- Error page consistency
- Message bundles
- Additional locale exercises
- Validation regression tests

Exit gate:
- Invalid input fails clearly and safely.
- User-facing messages come from a consistent message system.

---

# Phase 10 — Testing Strategy

## Batches 421-470

Goal: build confidence without redundant tests.

Planned work:
- JUnit 5 structure
- Unit tests
- MVC slice tests
- Repository tests
- Full integration tests
- Validation tests
- Parameterized tests
- Test fixtures/builders
- Boundary cases
- Regression tests for discovered bugs
- Concurrency-oriented tests where justified
- Coverage review
- Remove low-value duplicate tests

Exit gate:
- Every major feature has the right test type at the right layer.
- The suite catches meaningful regressions without testing framework internals.

---

# Phase 11 — MySQL, PostgreSQL, Docker Compose, Testcontainers

## Batches 471-510

Goal: prove the application is portable beyond H2.

Planned work:
- MySQL runtime profile
- PostgreSQL runtime profile
- Driver configuration
- Profile-specific properties
- Docker Compose database services
- Persistent DB startup
- Schema compatibility fixes
- Testcontainers integration
- MySQL integration test path
- PostgreSQL integration test path
- Environment variable configuration
- Connection failure diagnostics

Exit gate:
- The same application works against H2, MySQL, and PostgreSQL with profile/config changes rather than code rewrites.

---

# Phase 12 — Transactions, Concurrency, Cache

## Batches 511-550

Goal: study real backend behavior under competing requests and repeated reads.

Planned work:
- Transaction boundaries
- Rollback behavior
- Lazy loading boundaries
- Optimistic locking
- Conflict handling
- Lost-update scenarios
- Pessimistic locking comparison
- Concurrent request tests
- Idempotency exercises
- Cache introduction
- Cache invalidation
- Vet/specialty caching candidates
- Cache tests

Exit gate:
- Important writes have explicit transactional behavior.
- Concurrency failures are understood and handled deliberately.

---

# Phase 13 — Observability, Performance, Resilience

## Batches 551-590

Goal: operate and diagnose the application like a real service.

Planned work:
- Spring Boot Actuator
- Health/info endpoints
- Structured logging concepts
- Useful application logs
- SQL/query diagnostics
- Request timing
- Slow query identification
- N+1 regression checks
- JVM/runtime metrics introduction
- Failure injection exercises
- Database unavailable behavior
- Graceful error handling
- Basic load/performance exercises
- Dependency/startup diagnostics

Exit gate:
- A developer can explain what the app is doing and diagnose common runtime failures.

---

# Phase 14 — CI, Quality, Release Engineering

## Batches 591-620

Goal: make every change reproducibly buildable outside the developer laptop.

Planned work:
- GitHub Actions Maven build
- Test execution in CI
- Dependency caching
- Java matrix decisions
- Formatting rules
- Checkstyle/static quality gate
- Coverage reporting
- Reproducible build practices
- Build metadata
- Artifact generation
- Branch/pull-request workflow concepts
- Failed-pipeline diagnosis

Exit gate:
- A clean checkout builds and tests automatically in CI.

---

# Phase 15 — Deployment and Production Hardening

## Batches 621-640

Goal: package and run PetClinic as a deployable application.

Planned work:
- Executable jar review
- Spring Boot container image build
- Docker runtime configuration
- Environment-based configuration
- Secrets handling principles
- Production profile
- Database connectivity
- Health checks
- Graceful shutdown
- Runtime resource considerations
- Deployment smoke checks
- Rollback-ready artifact thinking

Exit gate:
- The application can be packaged, configured, started, checked, and stopped in a production-like environment.

---

# Phase 16 — Final Architecture and Interview Capstone

## Batches 641-650

Goal: prove understanding of the whole system.

Planned work:
- Full architecture diagram
- Request-to-database walkthrough
- Owner/Pet/Visit aggregate walkthrough
- Vet/Specialty walkthrough
- Spring Boot startup walkthrough
- MVC/JPA/validation/test architecture review
- Performance/concurrency review
- Production incident walkthrough
- Final cleanup/refactor
- Final build and capstone explanation

Final exit gate:
- Clean build
- Passing test suite
- Working UI
- H2 + persistent database profile
- CI green
- Deployable artifact
- Learner can explain the architecture and defend major implementation decisions

---

# Batch Construction Standard

A future teaching prompt should usually contain only:

1. Current relevant state
2. Goal
3. Files to create/change
4. Exact code/actions
5. One focused verification
6. Short learning summary
7. Expected final state

Do not inflate prompts with long lists of things not to do.

## Expected batch size

There is no artificial line-count quota, but normal implementation batches should be substantial enough to move the application forward.

Examples:
- One cohesive controller + template flow
- One entity + repository + focused test
- One configuration milestone
- One complete form workflow
- One production concern with its verification

A one-line code batch is allowed only when that single line represents a genuinely important standalone change. It must not become the normal pace.

---

# Roadmap Change Policy

This file is the source of truth for build order.

Before each new batch:
1. Inspect the real repository.
2. Locate the current phase in this roadmap.
3. Confirm prerequisites.
4. Choose the next coherent milestone.
5. If the planned order is no longer sensible, update this roadmap first and explain why.

This prevents silent curriculum drift and keeps future batches grounded in the actual repository.
