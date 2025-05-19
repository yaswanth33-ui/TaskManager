# Task Manager App

## JSON Entities

### Task
    {
	    "id": 1,
	    "title": "First task!",
	    "description": "This is the task description",
        "priority": "Easy",
	    "deadline": "dd/mm/yyyy",
        "completed": false,
        "notes": [
            {
              "title": "First note title",
              "description": "I am the note body"
            },
            {
              "title": "random note title",
              "description": "I am the note body"
            },
            {
              "title": "random note title",
              "description": "I am the note body"
            }
        ],
      
    }

## API Endpoints

### `POST /tasks`
Create a new task

### `GET /tasks`
Get all tasks


### `GET /tasks/{task_id}`
Get the details of a particular task including notes

### `PATCH /tasks/{task_id}`
Edit a task - Add / Remove notes from the task. Mark a task completed.

### `DELETE /tasks/{task_id}`
Delete a particular task

---- ADDITIONAL TASKS (BONUS) -----

### `GET  /tasks/{task_id}/notes`
Fetch all the notes under a particular task

### `POST  /tasks/{task_id}/notes`
Create a new note under the task with given task id

### `PATCH /tasks/{task_id}/notes/{notes_id}`
Edit a note for task - Modify title / description of notes

### `DELETE /tasks/{task_id}/notes/{notes_id}`
Delete a note