#!/bin/bash

# Exit on error
set -e

# Build the project
echo "Building project..."
mvn clean package

# Build Docker image
echo "Building Docker image..."
docker build -t student-management-system .

# Stop and remove existing container (if any)
echo "Stopping running container..."
docker stop student-management-system 2>/dev/null || true
docker rm student-management-system 2>/dev/null || true

# Run container with GUI support
echo "Running the container..."
docker run -d \
  --name student-management-system \
  -e DISPLAY=host.docker.internal:0 \
  -v /tmp/.X11-unix:/tmp/.X11-unix \
  student-management-system

echo "Deployment successful! GUI window should appear on your XServer."