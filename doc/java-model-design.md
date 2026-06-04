# Java Model Design - Version 1

## Partner

Represents a business partner using the MFT platform.

Fields:

* partnerId
* partnerName
* partnerCode
* contactEmail
* status
* createdAt

---

## User

Represents a platform user.

Fields:

* userId
* partnerId
* username
* password
* firstName
* lastName
* role
* createdAt

Roles:

* SUPER_ADMIN
* PARTNER_ADMIN
* PARTNER_USER

---

## Transfer

Represents a file transfer.

Fields:

* transferId
* partnerId
* uploadedBy
* fileName
* fileType
* fileSize
* status
* s3Key
* uploadTime
* validationMessage

---

## ProcessingReport

Represents processing results.

Fields:

* reportId
* transferId
* recordsRead
* recordsProcessed
* recordsFailed
* processingTime
* status
* createdAt

---

## AuditLog

Represents audit events.

Fields:

* auditId
* transferId
* performedBy
* action
* eventTimestamp
* remarks
