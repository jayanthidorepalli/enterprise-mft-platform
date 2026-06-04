Cloud-Native Managed File Transfer (MFT) Platform
Database Design v1
Overview
This platform enables business partners to securely upload, validate, process, monitor, and archive enterprise files such as:
CSV
XML
TXT
EDI
The platform supports:
Partner Management
User Management
File Transfer Tracking
Validation Engine
Processing Engine
Audit Trail
Processing Reports

PARTNERS
Stores partner organizations using the platform.
Column
Type
Description
partner_id
BIGINT
Primary Key
partner_name
VARCHAR(100)
Partner Name
partner_code
VARCHAR(50)
Unique Partner Code
contact_email
VARCHAR(255)
Contact Email
status
VARCHAR(20)
ACTIVE / INACTIVE
created_at
TIMESTAMP
Creation Timestamp

Example:
ABC Logistics
XYZ Retail
Global Finance

USERS
Stores users belonging to partners.
Column
Type
Description
user_id
BIGINT
Primary Key
partner_id
BIGINT
FK -> PARTNERS
username
VARCHAR(100)
Login Username
password
VARCHAR(255)
Encrypted Password
first_name
VARCHAR(100)
First Name
last_name
VARCHAR(100)
Last Name
role
VARCHAR(50)
User Role
created_at
TIMESTAMP
Creation Timestamp

Roles:
SUPER_ADMIN
PARTNER_ADMIN
PARTNER_USER

TRANSFERS
Stores uploaded file metadata.
Column
Type
Description
transfer_id
BIGINT
Primary Key
partner_id
BIGINT
FK -> PARTNERS
uploaded_by
BIGINT
FK -> USERS
file_name
VARCHAR(255)
Uploaded File Name
file_type
VARCHAR(50)
CSV/XML/TXT/EDI
file_size
BIGINT
File Size
status
VARCHAR(50)
Transfer Status
s3_key
VARCHAR(500)
S3 Object Path
upload_time
TIMESTAMP
Upload Timestamp
validation_message
TEXT
Validation Result

Status Values:
UPLOADED
VALIDATING
VALIDATED
QUEUED
PROCESSING
COMPLETED
FAILED
ARCHIVED

PROCESSING_REPORTS
Stores file processing results.
Column
Type
Description
report_id
BIGINT
Primary Key
transfer_id
BIGINT
FK -> TRANSFERS
records_read
INTEGER
Records Read
records_processed
INTEGER
Records Successfully Processed
records_failed
INTEGER
Failed Records
processing_time
BIGINT
Processing Duration
status
VARCHAR(50)
Processing Status
created_at
TIMESTAMP
Creation Timestamp

Example:
Records Read: 1000
Records Processed: 998
Records Failed: 2

AUDIT_LOGS
Stores platform activity history.
Column
Type
Description
audit_id
BIGINT
Primary Key
transfer_id
BIGINT
FK -> TRANSFERS
action
VARCHAR(100)
Action Performed
performed_by
BIGINT
User ID
timestamp
TIMESTAMP
Event Timestamp
remarks
TEXT
Additional Details

Example Actions:
FILE_UPLOADED
VALIDATION_STARTED
VALIDATION_COMPLETED
PROCESSING_STARTED
PROCESSING_COMPLETED
FILE_DOWNLOADED
FILE_ARCHIVED

Relationship Diagram
PARTNERS
|
+-- USERS
|
+-- TRANSFERS
|
+-- PROCESSING_REPORTS
|
+-- AUDIT_LOGS
One Partner -> Many Users
One Partner -> Many Transfers
One Transfer -> One Processing Report
One Transfer -> Many Audit Logs

